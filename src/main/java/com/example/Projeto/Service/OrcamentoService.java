package com.example.Projeto.Service;

import com.example.Projeto.Entity.*;
import com.example.Projeto.Exceptions.*;
import com.example.Projeto.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrcamentoService {
    private final OrcamentoRepository orcamentoRepository;
    private final ItemOrcamentoRepository itemOrcamentoRepository;
    private final CheckInRepository checkInRepository;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;
    private final ItemCheckInRepository itemCheckInRepository;


    public OrcamentoService(OrcamentoRepository orcamentoRepository, ItemOrcamentoRepository itemOrcamentoRepository, CheckInRepository checkInRepository,
            ClienteRepository clienteRepository, VeiculoRepository veiculoRepository, ItemCheckInRepository itemCheckInRepository) {

        this.orcamentoRepository = orcamentoRepository;
        this.itemOrcamentoRepository = itemOrcamentoRepository;
        this.checkInRepository = checkInRepository;
        this.clienteRepository = clienteRepository;
        this.veiculoRepository = veiculoRepository;
        this.itemCheckInRepository = itemCheckInRepository;
    }

    public Orcamento buscarPorId(Integer id){
        Optional<Orcamento> orcamento = orcamentoRepository.findById(id);

        if (orcamento.isEmpty()){
            throw new OrcamentoNaoEncontrado("Não encontrado");
        }
        return orcamento.get();
    }

    public List<ItemOrcamento> buscarItens(Integer orcamentoId){
        buscarPorId(orcamentoId);
        return itemOrcamentoRepository.findByOrcamento_IdOrderByIdAsc(orcamentoId);
    }

    private Orcamento montarOrcamento(Integer checkInId, Integer clienteId, Integer veiculoId) {
        Optional<CheckIn> checkIn = checkInRepository.findById(checkInId);

        if (checkIn.isEmpty()) {
            throw new CheckInNaoEncontrado("Check-in não encontrado");
        }
        if (orcamentoRepository.existsByCheckIn_Id(checkInId)) {
            throw new OrcamentoJaCadastrado("Este check-in já possui um orçamento");
        }
        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        if (cliente.isEmpty()) {
            throw new OrcamentoInvalido("Cliente informado não existe");
        }
        Optional<Veiculo> veiculo = veiculoRepository.findById(veiculoId);
        if (veiculo.isEmpty()) {
            throw new OrcamentoInvalido("Veículo informado não existe");
        }
        Veiculo veiculoEncontrado = veiculo.get();
        if (veiculoEncontrado.getCliente() == null || !veiculoEncontrado.getCliente().getId().equals(clienteId)) {
            throw new OrcamentoInvalido("O veículo não pertence ao cliente informado");
        }
        validarDadosCheckIn(checkIn.get(), cliente.get(), veiculoEncontrado);
        Orcamento orcamento = new Orcamento();
        orcamento.setCheckIn(checkIn.get());
        orcamento.setCliente(cliente.get());
        orcamento.setVeiculo(veiculoEncontrado);

        return orcamento;
    }
    private void validarDadosCheckIn(CheckIn checkIn, Cliente cliente, Veiculo veiculo) {
        String cpfCheckIn = checkIn.getCpfCliente().replaceAll("\\D", "");
        String cpfCliente = cliente.getCpf().replaceAll("\\D", "");

        if (!cpfCheckIn.equals(cpfCliente)) {
            throw new OrcamentoInvalido("O CPF do cliente não corresponde ao CPF do check-in");
        }
        String placaCheckIn = checkIn.getPlacaVeiculo().replaceAll("[\\s-]", "");
        String placaVeiculo = veiculo.getPlaca().replaceAll("[\\s-]", "");
        if (!placaCheckIn.equalsIgnoreCase(placaVeiculo)) {
            throw new OrcamentoInvalido("A placa do veículo não corresponde à placa do check-in");
        }
    }

    private void validarItens(CheckIn checkIn, List<ItemOrcamento> itens) {
        for (ItemOrcamento item : itens) {
            if (item.getItemCheckIn() != null) {
                Integer origemId = item.getItemCheckIn().getId();
                Optional<ItemCheckIn> origem = itemCheckInRepository.findById(origemId);

                if (origem.isEmpty()) {
                    throw new OrcamentoInvalido("Item do check-in não encontrado");
                }
                ItemCheckIn itemEncontrado = origem.get();
                if (!itemEncontrado.getCheckIn().getId().equals(checkIn.getId())) {
                    throw new OrcamentoInvalido("O item pertence a outro check-in");
                }
                if (!Boolean.TRUE.equals(itemEncontrado.getTemProblema())) {
                    throw new OrcamentoInvalido("O item não está marcado como problema");
                }

                item.setItemCheckIn(itemEncontrado);
            }
        }
    }

    @Transactional
    public Orcamento cadastrar(Integer checkInId, Integer clienteId, Integer veiculoId, List<ItemOrcamento> itens) {
        Orcamento orcamento = montarOrcamento(checkInId, clienteId, veiculoId);
        validarItens(orcamento.getCheckIn(), itens);
        double total = 0.0;

        for (ItemOrcamento item : itens) {
            double precoFinal = item.getQuantidade() * item.getPrecoUnitario();
            precoFinal = Math.round(precoFinal * 100.0) / 100.0;
            item.setPrecoFinal(precoFinal);
            total += precoFinal;
        }

        orcamento.setTotal(Math.round(total * 100.0) / 100.0);
        orcamento.setStatus(StatusOrcamento.PENDENTE);
        orcamento.setDataCriacao(LocalDateTime.now());
        Orcamento orcamentoSalvo = orcamentoRepository.save(orcamento);

        for (ItemOrcamento item : itens) {
            item.setOrcamento(orcamentoSalvo);
        }
        itemOrcamentoRepository.saveAll(itens);
        return orcamentoSalvo;
    }

    public List<Orcamento> listar(){
        return orcamentoRepository.findAll();
    }

    @Transactional
    public Orcamento atualizar(Integer id, Integer checkInId, Integer clienteId, Integer veiculoId, List<ItemOrcamento> itens) {
        Orcamento orcamento = buscarPorId(id);
        verificarEdicao(orcamento);

        if (!orcamento.getCheckIn().getId().equals(checkInId) || !orcamento.getCliente().getId().equals(clienteId) || !orcamento.getVeiculo().getId().equals(veiculoId)) {
            throw new OrcamentoInvalido("A edição deve manter o check-in, cliente e veículo");
        }
        validarItens(orcamento.getCheckIn(), itens);
        double total = 0.0;

        for (ItemOrcamento item : itens) {
            double precoFinal = item.getQuantidade() * item.getPrecoUnitario();
            precoFinal = Math.round(precoFinal * 100.0) / 100.0;
            item.setPrecoFinal(precoFinal);
            item.setOrcamento(orcamento);
            total += precoFinal;
        }

        List<ItemOrcamento> itensAntigos = itemOrcamentoRepository.findByOrcamento_IdOrderByIdAsc(id);
        itemOrcamentoRepository.deleteAll(itensAntigos);
        orcamento.setTotal(Math.round(total * 100.0) / 100.0);
        Orcamento orcamentoSalvo = orcamentoRepository.save(orcamento);
        itemOrcamentoRepository.saveAll(itens);

        return orcamentoSalvo;
    }

    private void verificarEdicao(Orcamento orcamento) {
        if (orcamento.getStatus() != StatusOrcamento.PENDENTE) {
            throw new OrcamentoNaoPodeSerAlterado("Somente orçamentos pendentes podem ter seus itens e valores editados");
        }
    }

    @Transactional
    public Orcamento atualizarStatus(Integer id, StatusOrcamento novoStatus) {
        Orcamento orcamento = buscarPorId(id);
        StatusOrcamento statusAtual = orcamento.getStatus();

        boolean podeAvancar = (statusAtual == StatusOrcamento.PENDENTE && novoStatus == StatusOrcamento.EM_ANDAMENTO)
                        || (statusAtual == StatusOrcamento.EM_ANDAMENTO && novoStatus == StatusOrcamento.FINALIZADO)
                        || (statusAtual == StatusOrcamento.FINALIZADO && novoStatus == StatusOrcamento.ENTREGUE);

        boolean podeCancelar =
                novoStatus == StatusOrcamento.CANCELADO && (statusAtual == StatusOrcamento.PENDENTE || statusAtual == StatusOrcamento.EM_ANDAMENTO);

        if (!podeAvancar && !podeCancelar) {
            throw new OrcamentoInvalido("Não é permitido mudar de " + statusAtual + " para " + novoStatus);
        }
        orcamento.setStatus(novoStatus);
        return orcamentoRepository.save(orcamento);
    }
}
