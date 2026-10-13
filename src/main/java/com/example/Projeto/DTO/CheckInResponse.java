package com.example.Projeto.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class CheckInResponse {
    private Integer id;
    private String nomeCliente;
    private String cpfCliente;
    private String placaVeiculo;
    private String modeloVeiculo;
    private Integer kmVeiculo;
    private LocalDateTime dataInspecao;
    private Integer mecanicoId;
    private List<ItemCheckInResponse> itens;

    public CheckInResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getModeloVeiculo() {
        return modeloVeiculo;
    }

    public void setModeloVeiculo(String modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    public Integer getKmVeiculo() {
        return kmVeiculo;
    }

    public void setKmVeiculo(Integer kmVeiculo) {
        this.kmVeiculo = kmVeiculo;
    }

    public LocalDateTime getDataInspecao() {
        return dataInspecao;
    }

    public void setDataInspecao(LocalDateTime dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    public Integer getMecanicoId() {
        return mecanicoId;
    }

    public void setMecanicoId(Integer mecanicoId) {
        this.mecanicoId = mecanicoId;
    }

    public List<ItemCheckInResponse> getItens() {
        return itens;
    }

    public void setItens(List<ItemCheckInResponse> itens) {
        this.itens = itens;
    }
}
