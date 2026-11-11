package com.nexus.Mapper;

import com.nexus.DTO.ItemOrcamentoRequest;
import com.nexus.DTO.ItemOrcamentoResponse;
import com.nexus.Entity.ItemCheckIn;
import com.nexus.Entity.ItemOrcamento;

public class ItemOrcamentoMapper {
    public static ItemOrcamento toEntity(ItemOrcamentoRequest request) {
        ItemOrcamento item = new ItemOrcamento();
        item.setDescricao(request.getDescricao());
        item.setQuantidade(request.getQuantidade());
        item.setPrecoUnitario(request.getPrecoUnitario());

        if (request.getItemCheckInId() != null) {
            ItemCheckIn origem = new ItemCheckIn();
            origem.setId(request.getItemCheckInId());
            item.setItemCheckIn(origem);
        }

        return item;
    }

    public static ItemOrcamentoResponse toResponse(ItemOrcamento item) {
        ItemOrcamentoResponse response = new ItemOrcamentoResponse();
        response.setId(item.getId());
        response.setDescricao(item.getDescricao());
        response.setQuantidade(item.getQuantidade());
        response.setPrecoUnitario(item.getPrecoUnitario());
        response.setPrecoFinal(item.getPrecoFinal());

        if (item.getItemCheckIn() != null) {
            response.setItemCheckInId(item.getItemCheckIn().getId());
        }
        return response;
    }
}