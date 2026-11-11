package com.nexus.DTO;

import com.nexus.Entity.StatusOrcamento;
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