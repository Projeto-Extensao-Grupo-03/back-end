package com.example.Projeto.DTO;

import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Validation.Placa;
import jakarta.validation.constraints.NotBlank;

public class VeiculoRequest {

    @NotBlank(message = "A placa é obrigatória")
    @Placa
    private String placa;

    @NotBlank
    private String chassi;

    @NotBlank
    private Integer km;
    private Cliente cliente;
    private Integer clienteId;

    public VeiculoRequest() {
    }

    public VeiculoRequest(String placa, String chassi, Integer km, Cliente cliente, Integer clienteId) {
        this.placa = placa;
        this.chassi = chassi;
        this.km = km;
        this.cliente = cliente;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
}
