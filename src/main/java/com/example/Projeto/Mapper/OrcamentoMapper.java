package com.example.Projeto.Mapper;

import com.example.Projeto.DTO.ItemOrcamentoResponse;
import com.example.Projeto.DTO.OrcamentoResponse;
import com.example.Projeto.Entity.ItemOrcamento;
import com.example.Projeto.Entity.Orcamento;

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