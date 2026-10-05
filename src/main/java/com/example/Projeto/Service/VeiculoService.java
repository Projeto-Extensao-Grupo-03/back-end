package com.example.Projeto.Service;

import com.example.Projeto.Entity.Veiculo;
import com.example.Projeto.Repository.VeiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> listar() {
        return veiculoRepository.findAll();
    }
}
