package com.example.Projeto.DTO;

import com.example.Projeto.Entity.StatusOrcamento;

import java.time.LocalDateTime;
import java.util.List;

public class OrcamentoResponse {
    private Integer id;
    private Integer checkInId;
    private Integer clienteId;
    private Integer veiculoId;
    private StatusOrcamento status;
    private LocalDateTime dataCriacao;
    private Double total;
    private List<ItemOrcamentoResponse> itens;

    public OrcamentoResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public StatusOrcamento getStatus() {
        return status;
    }

    public void setStatus(StatusOrcamento status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemOrcamentoResponse> getItens() {
        return itens;
    }

    public void setItens(List<ItemOrcamentoResponse> itens) {
        this.itens = itens;
    }
}