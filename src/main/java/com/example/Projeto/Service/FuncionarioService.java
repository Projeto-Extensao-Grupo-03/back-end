package com.example.Projeto.Service;

import com.example.Projeto.Entity.Funcionario;
import com.example.Projeto.Repository.FuncionarioRepository;

import java.util.List;

public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarAll(){

        return funcionarioRepository.findAll();
    }
}
