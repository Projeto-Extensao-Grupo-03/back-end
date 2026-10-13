package com.example.Projeto.Service;

import com.example.Projeto.Entity.CheckIn;
import com.example.Projeto.Entity.ItemCheckIn;
import com.example.Projeto.Entity.Mecanico;
import com.example.Projeto.Entity.Orcamento;
import com.example.Projeto.Exceptions.CheckInNaoEncontrado;
import com.example.Projeto.Exceptions.MecanicoNaoExiste;
import com.example.Projeto.Repository.CheckInRepository;
import com.example.Projeto.Repository.ItemCheckInRepository;
import com.example.Projeto.Repository.MecanicoRepositoy;
import com.example.Projeto.Exceptions.CheckInVinculado;
import com.example.Projeto.Repository.OrcamentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CheckInService {
    private final CheckInRepository checkInRepository;
    private final ItemCheckInRepository itemCheckInRepository;
    private final MecanicoRepositoy mecanicoRepositoy;
    private final OrcamentoRepository orcamentoRepository;

    public CheckInService(CheckInRepository checkInRepository, ItemCheckInRepository itemCheckInRepository, MecanicoRepositoy mecanicoRepositoy,
    OrcamentoRepository orcamentoRepository){
        this.checkInRepository = checkInRepository;
        this.itemCheckInRepository = itemCheckInRepository;
        this.mecanicoRepositoy = mecanicoRepositoy;
        this.orcamentoRepository = orcamentoRepository;
    }

    public CheckIn buscarPorId(Integer id){
        Optional<CheckIn> checkIn = checkInRepository.findById(id);

        if (checkIn.isEmpty()){
            throw new CheckInNaoEncontrado("Não encontrado");
        }

        return checkIn.get();
    }

    public List<ItemCheckIn> buscarItens(Integer checkInId){
        buscarPorId(checkInId);

        return itemCheckInRepository.findByCheckIn_IdOrderByNumeroItemAsc(checkInId);
    }

    @Transactional
    public CheckIn cadastrar(CheckIn checkIn, Integer mecanicoId, List<ItemCheckIn> itens){
        Optional<Mecanico> mecanico = mecanicoRepositoy.findById(mecanicoId);

        if (mecanico.isEmpty()){
            throw new MecanicoNaoExiste("Mecanico não existe");
        }

        checkIn.setMecanico(mecanico.get());
        checkIn.setDataInspecao(LocalDateTime.now());
        CheckIn checkInSalvo = checkInRepository.save(checkIn);

        for (ItemCheckIn item : itens) {
            item.setCheckIn(checkInSalvo);
        }

        itemCheckInRepository.saveAll(itens);

        return checkInSalvo;
    }

    public List<CheckIn> listar(){
        return checkInRepository.findAll();
    }

    @Transactional
    public CheckIn atualizar(CheckIn dados, Integer id, Integer mecanicoId, List<ItemCheckIn> itens) {
        CheckIn checkIn = buscarPorId(id);
        verificarVinculoComOrcamento(id);
        Optional<Mecanico> mecanico = mecanicoRepositoy.findById(mecanicoId);


        if (mecanico.isEmpty()) {
            throw new MecanicoNaoExiste("Mecânico não encontrado!");
        }

        checkIn.setNomeCliente(dados.getNomeCliente());
        checkIn.setCpfCliente(dados.getCpfCliente());
        checkIn.setPlacaVeiculo(dados.getPlacaVeiculo());
        checkIn.setModeloVeiculo(dados.getModeloVeiculo());
        checkIn.setKmVeiculo(dados.getKmVeiculo());
        checkIn.setMecanico(mecanico.get());

        List<ItemCheckIn> itensAtuais = itemCheckInRepository.findByCheckIn_IdOrderByNumeroItemAsc(id);
        itemCheckInRepository.deleteAll(itensAtuais);
        CheckIn checkInAtualizado = checkInRepository.save(checkIn);

        for (ItemCheckIn item : itens) {
            item.setCheckIn(checkInAtualizado);
        }
        itemCheckInRepository.saveAll(itens);

        return checkInAtualizado;
    }

    @Transactional
    public void deletar(Integer id) {CheckIn checkIn = buscarPorId(id);
        List<ItemCheckIn> itens = itemCheckInRepository.findByCheckIn_IdOrderByNumeroItemAsc(id);
        verificarVinculoComOrcamento(id);
        itemCheckInRepository.deleteAll(itens);
        checkInRepository.delete(checkIn);
    }

    private void verificarVinculoComOrcamento(Integer checkInId) {
        if (orcamentoRepository.existsByCheckIn_Id(checkInId)) {
            throw new CheckInVinculado("Vinculado! não pode ser alterado ou excluido.");
        }
    }

}
