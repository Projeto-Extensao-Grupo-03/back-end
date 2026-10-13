package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OrcamentoJaCadastrado extends RuntimeException {
    public OrcamentoJaCadastrado(String mensagem) {
        super(mensagem);
    }
}
