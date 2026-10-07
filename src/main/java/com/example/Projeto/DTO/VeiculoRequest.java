package com.example.Projeto.DTO;

import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Validation.Placa;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class VeiculoRequest {

    @NotBlank(message = "A placa é obrigatória")
    @Placa
    private String placa;

    @NotBlank
    private String chassi;

    @NotNull
    private Integer km;

    @NotNull
    private Integer clienteId;

    public VeiculoRequest() {
    }

    public VeiculoRequest(String placa, String chassi, Integer km, Integer clienteId) {
        this.placa = placa;
        this.chassi = chassi;
        this.km = km;
        this.clienteId = clienteId;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
