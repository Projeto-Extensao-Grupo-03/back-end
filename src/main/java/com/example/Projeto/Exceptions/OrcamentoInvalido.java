package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrcamentoInvalido extends RuntimeException {
    public OrcamentoInvalido(String mensagem) {
        super(mensagem);
    }
}