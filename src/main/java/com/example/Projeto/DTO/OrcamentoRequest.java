package com.example.Projeto.DTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.List;

public class OrcamentoRequest {
    @NotNull
    @Positive
    private Integer checkInId;
    @NotNull
    @Positive
    private Integer clienteId;
    @NotNull
    @Positive
    private Integer veiculoId;
    @NotEmpty
    @Valid
    private List<@NotNull ItemOrcamentoRequest> itens;

    public OrcamentoRequest() {
    }

    public Integer getCheckInId() {
        return checkInId;
    }

    public void setCheckInId(Integer checkInId) {
        this.checkInId = checkInId;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public Integer getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Integer veiculoId) {
        this.veiculoId = veiculoId;
    }

    public List<ItemOrcamentoRequest> getItens() {
        return itens;
    }

    public void setItens(List<ItemOrcamentoRequest> itens) {
        this.itens = itens;
    }
}