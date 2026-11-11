package com.nexus.Mapper;

import com.nexus.DTO.ItemOrcamentoResponse;
import com.nexus.DTO.OrcamentoResponse;
import com.nexus.Entity.ItemOrcamento;
import com.nexus.Entity.Orcamento;

import java.util.ArrayList;
import java.util.List;


public class OrcamentoMapper {
    public static OrcamentoResponse toResponse(Orcamento orcamento, List<ItemOrcamento> itens) {
        OrcamentoResponse response = new OrcamentoResponse();

        response.setId(orcamento.getId());
        response.setCheckInId(orcamento.getCheckIn().getId());
        response.setClienteId(orcamento.getCliente().getId());
        response.setVeiculoId(orcamento.getVeiculo().getId());
        response.setStatus(orcamento.getStatus());
        response.setDataCriacao(orcamento.getDataCriacao());
        response.setTotal(orcamento.getTotal());

        List<ItemOrcamentoResponse> respostas = new ArrayList<>();

        for (ItemOrcamento item : itens) {
            respostas.add(ItemOrcamentoMapper.toResponse(item));
        }
        response.setItens(respostas);
        return response;
    }
}