package com.example.Projeto.DTO;

public class FuncionarioRequest {
    private String codigo;

    private String nome;

    private Integer ativo;

    public FuncionarioRequest() {
    }

    public FuncionarioRequest(String codigo, String nome, Integer ativo) {
        this.codigo = codigo;
        this.nome = nome;
        this.ativo = ativo;
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
