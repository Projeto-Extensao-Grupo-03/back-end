package com.example.Projeto.Entity;

import com.example.Projeto.Validation.Placa;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String placa;
    private String chassi;
    private Integer km;

    @ManyToOne
    private Cliente cliente;

    public Veiculo() {
    }

    public Veiculo(Integer id, String placa, String chassi, Integer km, Cliente cliente) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.km = km;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
