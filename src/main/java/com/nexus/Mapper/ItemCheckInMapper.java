package com.nexus.Mapper;

import com.nexus.DTO.ItemCheckInRequest;
import com.nexus.DTO.ItemCheckInResponse;
import com.nexus.Entity.ItemCheckIn;

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
