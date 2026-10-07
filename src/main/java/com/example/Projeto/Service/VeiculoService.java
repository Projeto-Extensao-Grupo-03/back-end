package com.example.Projeto.Service;

import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Entity.Veiculo;
import com.example.Projeto.Exceptions.ClienteNaoExiste;
import com.example.Projeto.Exceptions.VeiculoDuplicado;
import com.example.Projeto.Exceptions.VeiculoNaoEncontrado;
import com.example.Projeto.Repository.ClienteRepository;
import com.example.Projeto.Repository.VeiculoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoService(VeiculoRepository veiculoRepository, ClienteRepository clienteRepository) {
        this.veiculoRepository = veiculoRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Integer id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);
        if (veiculo.isEmpty()) {
            throw new VeiculoNaoEncontrado("Veículo não encontrado!");
        }

        return veiculo.get();
    }

    public Veiculo cadastrar(Veiculo veiculo, Integer clientId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clientId);
        if (clienteOptional.isEmpty()) {
            throw new ClienteNaoExiste("Cliente não encontrado!");
        }

        if (veiculoRepository.existsByPlacaAndCliente(veiculo.getPlaca(), clienteOptional.get())) {
            throw new VeiculoDuplicado("Este veículo já existe para este cliente!");
        }

        veiculo.setCliente(clienteOptional.get());
        return veiculoRepository.save(veiculo);
    }

    public Veiculo atualizar(Veiculo veiculo, Integer id, Integer clientId) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(clientId);
        if (clienteOptional.isEmpty()) {
            throw new ClienteNaoExiste("Cliente não encontrado!");
        }

        if (!veiculoRepository.existsById(id)) {
            throw new VeiculoNaoEncontrado("Veículo não encontrado!");
        }

        veiculo.setCliente(clienteOptional.get());

        if (veiculoRepository.existsByPlacaAndClienteAndIdNot(veiculo.getPlaca(), veiculo.getCliente(), id)) {
            throw new VeiculoDuplicado("Veículo duplicado!");
        }

        veiculo.setId(id);
        return veiculoRepository.save(veiculo);
    }
}
