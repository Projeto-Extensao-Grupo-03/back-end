package com.example.Projeto.Mapper;

import com.example.Projeto.DTO.ClienteResponse;
import com.example.Projeto.DTO.MecanicoRequest;
import com.example.Projeto.DTO.MecanicoResponse;
import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Entity.Mecanico;

import java.util.ArrayList;
import java.util.List;

public class MecanicoMapper {

    public static MecanicoResponse toResponse(Mecanico mecanico){

        return new MecanicoResponse(
                mecanico.getId(),
                mecanico.getCodigo(),
                mecanico.getNome(),
                mecanico.getAtivo(),
                mecanico.getCpf(),
                mecanico.getDataNascimento(),
                mecanico.getEmail(),
                mecanico.getNumeroTelefone()
        );
    }

    public static Mecanico toEntity(MecanicoRequest request){

        return new Mecanico(
                null,
                null,
                request.getNome(),
                request.getAtivo(),
                request.getCpf(),
                request.getDataNascimento(),
                request.getEmail(),
                request.getNumeroTelefone()
        );
    }

    public static List<MecanicoResponse> listEntityToResponse(List<Mecanico> mecanicos){
        List<MecanicoResponse> responses = new ArrayList<>();

        for (Mecanico mecanico : mecanicos) {
            MecanicoResponse res = new MecanicoResponse(
                    mecanico.getId(),
                    mecanico.getCodigo(),
                    mecanico.getNome(),
                    mecanico.getAtivo(),
                    mecanico.getCpf(),
                    mecanico.getDataNascimento(),
                    mecanico.getEmail(),
                    mecanico.getNumeroTelefone()
            );

            responses.add(res);
        }

        return responses;
    }

}
