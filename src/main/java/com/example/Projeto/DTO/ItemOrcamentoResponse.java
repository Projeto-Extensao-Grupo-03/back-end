package com.example.Projeto.DTO;

public class ItemOrcamentoResponse {
    private Integer id;
    private String descricao;
    private Integer quantidade;
    private Double precoUnitario;
    private Double precoFinal;
    private Integer itemCheckInId;

    public ItemOrcamentoResponse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public Integer getItemCheckInId() {
        return itemCheckInId;
    }

    public void setItemCheckInId(Integer itemCheckInId) {
        this.itemCheckInId = itemCheckInId;
    }
}