package com.example.Projeto.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

public class MecanicoRequest {
    @NotNull
    @NotBlank
    @Size(min=1, max=100)
    private String nome;

    @NotNull
    @Size(min=1, max=1)
    private Integer ativo;

    @NotBlank
    @CPF
    String cpf;

    @NotNull
    @Past
    LocalDate dataNascimento;

    @Email
    @NotBlank
    String email;

    @NotNull
    Long numeroTelefone;

    public MecanicoRequest() {
    }


    public MecanicoRequest(String nome, Integer ativo, String cpf, LocalDate dataNascimento, String email, Long numeroTelefone) {
        this.nome = nome;
        this.ativo = ativo;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.numeroTelefone = numeroTelefone;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(Long numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
}
