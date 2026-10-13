package com.example.Projeto.DTO;

import com.example.Projeto.Entity.StatusOrcamento;
import jakarta.validation.constraints.NotNull;

public class StatusOrcamentoRequest {
    @NotNull
    private StatusOrcamento status;

    public StatusOrcamentoRequest() {}

    public StatusOrcamento getStatus() {
        return status;
    }

    public void setStatus(StatusOrcamento status) {
        this.status = status;
    }
}