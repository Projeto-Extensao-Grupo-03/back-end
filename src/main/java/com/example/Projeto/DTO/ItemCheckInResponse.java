package com.example.Projeto.DTO;

public class ItemCheckInResponse {
    private Integer id;
    private Integer numeroItem;
    private Boolean temProblema;
    private String observacao;

    public ItemCheckInResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        this.numeroItem = numeroItem;
    }

    public Boolean getTemProblema() {
        return temProblema;
    }

    public void setTemProblema(Boolean temProblema) {
        this.temProblema = temProblema;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
