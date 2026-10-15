package com.example.Projeto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min=1,max=20)
    private String codigo;

    @NotNull
    @NotBlank
    @Size(min=1, max=100)
    private String nome;

    @NotNull
    @Size(min=1, max=1)
    private Integer ativo;

    public Funcionario() {
    }

    public Funcionario(Integer id, String codigo, String nome, Integer ativo) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAtivo() {
        return ativo;
    }

    public void setAtivo(Integer ativo) {
        this.ativo = ativo;
    }
}
