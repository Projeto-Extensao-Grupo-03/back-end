package com.example.Projeto.Entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "revisao_inspecao")
public class CheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeCliente;
    private String cpfCliente;
    private String placaVeiculo;
    private String modeloVeiculo;
    private Integer kmVeiculo;
    @Column(nullable = false)
    private LocalDateTime dataInspecao;
    @ManyToOne(optional = false)
    @JoinColumn(name = "mecanico_fk", nullable = false)
    private Mecanico mecanico;

    public CheckIn() {
    }

    public CheckIn(Integer id) {
        this.id = id;
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

    public Mecanico getMecanico() {
        return mecanico;
    }

    public void setMecanico(Mecanico mecanico) {
        this.mecanico = mecanico;
    }
}
