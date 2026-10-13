package com.example.Projeto.Mapper;

import com.example.Projeto.DTO.CheckInRequest;
import com.example.Projeto.DTO.CheckInResponse;
import com.example.Projeto.DTO.ItemCheckInResponse;
import com.example.Projeto.Entity.CheckIn;
import com.example.Projeto.Entity.ItemCheckIn;

import java.util.ArrayList;
import java.util.List;

public class CheckInMapper {
    public static CheckIn toEntity(CheckInRequest request){
        CheckIn checkIn = new CheckIn();

        checkIn.setNomeCliente(request.getNomeCliente());
        checkIn.setCpfCliente(request.getCpfCliente());
        checkIn.setPlacaVeiculo(request.getPlacaVeiculo());
        checkIn.setModeloVeiculo(request.getModeloVeiculo());
        checkIn.setKmVeiculo(request.getKmVeiculo());

        return checkIn;
    }

    public static CheckInResponse toResponse(CheckIn checkIn, List<ItemCheckIn> itens){
        CheckInResponse response = new CheckInResponse();

        response.setId(checkIn.getId());
        response.setNomeCliente(checkIn.getNomeCliente());
        response.setCpfCliente(checkIn.getCpfCliente());
        response.setPlacaVeiculo(checkIn.getPlacaVeiculo());
        response.setModeloVeiculo(checkIn.getModeloVeiculo());
        response.setKmVeiculo(checkIn.getKmVeiculo());
        response.setDataInspecao(checkIn.getDataInspecao());
        response.setMecanicoId(checkIn.getMecanico().getId());

        List<ItemCheckInResponse> respostas = new ArrayList<>();
        for (ItemCheckIn item : itens) {
            respostas.add(ItemCheckInMapper.toResponse(item));
        }
        response.setItens(respostas);

        return response;
    }
}
