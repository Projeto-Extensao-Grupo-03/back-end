package com.nexus.Mapper;

import com.nexus.DTO.ClienteRequest;
import com.nexus.DTO.ClienteResponse;
import com.nexus.Entity.Cliente;

public class ClienteMapper {

    public static ClienteResponse toResponse(Cliente cLiente){
        ClienteResponse response = new ClienteResponse();
        response.setCpf(cLiente.getCpf());
        response.setDataNascimento(cLiente.getDataNascimento());
        response.setNome(cLiente.getNome());
        response.setEmail(cLiente.getEmail());
        response.setNumeroTelefone(cLiente.getNumeroTelefone());
        return response;
    }
    public static Cliente toEntity(ClienteRequest request){
        Cliente cliente = new Cliente(
                null,
                request.getNome(),
                request.getCpf(),
                request.getDataNascimento(),
                request.getEmail(),
                request.getNumeroTelefone()
        );
    return cliente;
    }
}
