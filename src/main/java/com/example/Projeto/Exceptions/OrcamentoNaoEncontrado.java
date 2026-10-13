package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrcamentoNaoEncontrado extends RuntimeException {
    public OrcamentoNaoEncontrado(String message) {
        super(message);
    }
}
