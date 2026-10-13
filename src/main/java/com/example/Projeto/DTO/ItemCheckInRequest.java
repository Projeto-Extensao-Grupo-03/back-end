package com.example.Projeto.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ItemCheckInRequest {
    @NotNull
    @Min(1)
    @Max(28)
    private Integer numeroItem;
    @NotNull
    private Boolean temProblema;
    @Size(max = 2000)
    private String observacao;

    public ItemCheckInRequest() {
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
