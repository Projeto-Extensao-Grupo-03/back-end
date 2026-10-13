package com.example.Projeto.Mapper;

import com.example.Projeto.DTO.CheckInRequest;
import com.example.Projeto.DTO.ItemCheckInRequest;
import com.example.Projeto.DTO.ItemCheckInResponse;
import com.example.Projeto.Entity.ItemCheckIn;

public class ItemCheckInMapper {
    public static ItemCheckIn toEntity(ItemCheckInRequest request){
        ItemCheckIn item = new ItemCheckIn();

        item.setNumeroItem(request.getNumeroItem());
        item.setTemProblema(request.getTemProblema());
        item.setObservacao(request.getObservacao());

        return item;
    }

    public static ItemCheckInResponse toResponse(ItemCheckIn item){
        ItemCheckInResponse response = new ItemCheckInResponse();

        response.setId(item.getId());
        response.setNumeroItem(item.getNumeroItem());
        response.setTemProblema(item.getTemProblema());
        response.setObservacao(item.getObservacao());

        return response;
    }
}
