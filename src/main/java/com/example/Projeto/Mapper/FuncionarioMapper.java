package com.example.Projeto.Mapper;


import com.example.Projeto.DTO.FuncionarioRequest;
import com.example.Projeto.DTO.FuncionarioResponse;
import com.example.Projeto.DTO.VeiculoResponse;
import com.example.Projeto.Entity.Funcionario;
import com.example.Projeto.Entity.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioMapper {

    public static List<FuncionarioResponse> toListResponse(List<Funcionario> funcionarios) {
        if (funcionarios == null) {return null;}

        List<FuncionarioResponse> funcionarioResponses = new ArrayList<>();

        for (Funcionario funcionario : funcionarios) {
            FuncionarioResponse funcionarioRes = new FuncionarioResponse(
                    funcionario.getId(),
                    funcionario.getCodigo(),
                    funcionario.getNome(),
                    funcionario.getAtivo()
            );

            funcionarioResponses.add(funcionarioRes);
        }

        return funcionarioResponses;
    }

    public static FuncionarioResponse toResponse(Funcionario funcionario) {
        if (funcionario == null) {return null;}

        return new FuncionarioResponse(
                funcionario.getId(),
                funcionario.getCodigo(),
                funcionario.getNome(),
                funcionario.getAtivo()
        );

    }

    public static Funcionario toEntity(FuncionarioRequest funcionarioRequest) {
        if (funcionarioRequest == null) {return null;}

        return new Funcionario(
                null,
                funcionarioRequest.getCodigo(),
                funcionarioRequest.getNome(),
                funcionarioRequest.getAtivo());
    }
}
