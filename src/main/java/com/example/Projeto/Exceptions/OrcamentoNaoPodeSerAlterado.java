package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OrcamentoNaoPodeSerAlterado extends RuntimeException {
    public OrcamentoNaoPodeSerAlterado(String mensagem) {super(mensagem);}
}