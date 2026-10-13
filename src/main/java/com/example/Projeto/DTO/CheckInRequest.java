package com.example.Projeto.DTO;

import com.example.Projeto.Validation.Placa;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public class CheckInRequest {
    @NotBlank
    @Size(max = 255)
    private String nomeCliente;
    @NotBlank
    @CPF
    private String cpfCliente;
    @NotBlank
    @Placa
    private String placaVeiculo;
    @NotBlank
    @Size(max = 255)
    private String modeloVeiculo;
    @NotNull
    @PositiveOrZero
    private Integer kmVeiculo;
    @NotNull
    @Positive
    private Integer mecanicoId;
    @NotNull
    @Size(min = 28, max = 28)
    @Valid
    private List<@NotNull ItemCheckInRequest> itens;

    public CheckInRequest (){}

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

    public Integer getMecanicoId() {
        return mecanicoId;
    }

    public void setMecanicoId(Integer mecanicoId) {
        this.mecanicoId = mecanicoId;
    }

    public List<ItemCheckInRequest> getItens() {
        return itens;
    }

    public void setItens(List<ItemCheckInRequest> itens) {
        this.itens = itens;
    }
}
