package com.example.Projeto.DTO;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class ItemOrcamentoRequest {
    @NotBlank
    @Size(max = 255)
    private String descricao;
    @NotNull
    @Positive
    private Integer quantidade;
    @NotNull
    @DecimalMin("0.00")
    private Double precoUnitario;
    @Positive
    private Integer itemCheckInId;
    public ItemOrcamentoRequest() {
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

    public Integer getItemCheckInId() {
        return itemCheckInId;
    }

    public void setItemCheckInId(Integer itemCheckInId) {
        this.itemCheckInId = itemCheckInId;
    }
}