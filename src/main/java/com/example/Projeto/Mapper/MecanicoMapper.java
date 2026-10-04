package com.example.Projeto.Mapper;

import com.example.Projeto.DTO.ClienteResponse;
import com.example.Projeto.DTO.MecanicoRequest;
import com.example.Projeto.DTO.MecanicoResponse;
import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Entity.Mecanico;

public class MecanicoMapper {

    public static MecanicoResponse toResponse(Mecanico mecanico){
        MecanicoResponse response = new MecanicoResponse();
        response.setCodigo(mecanico.getCodigo());
        response.setCpf(mecanico.getCpf());
        response.setDataNascimento(mecanico.getDataNascimento());
        response.setEmail(mecanico.getEmail());
        response.setNome(mecanico.getNome());
        response.setNumeroTelefone(mecanico.getNumeroTelefone());
        return response;
    }

    public  static Mecanico toEntity(MecanicoRequest request){
        Mecanico mecanico = new Mecanico(
                null,
                request.getNome(),
                request.getCpf(),
                request.getDataNascimento(),
                request.getEmail(),
                request.getNumeroTelefone(),
                request.getCodigo()
        );

        return mecanico;
    }

}
