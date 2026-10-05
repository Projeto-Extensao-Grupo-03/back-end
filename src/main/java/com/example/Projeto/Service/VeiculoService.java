package com.example.Projeto.Service;

import com.example.Projeto.Entity.Veiculo;
import com.example.Projeto.Exceptions.VeiculoNaoEncontrado;
import com.example.Projeto.Repository.VeiculoRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }

    public Veiculo buscarPorId(Integer id) {
        Optional<Veiculo> veiculo = veiculoRepository.findById(id);

        if (veiculo.isEmpty()) {
            throw new VeiculoNaoEncontrado("Veicúlo não encontrado!");
        }

        return veiculo.get();
    }
}
