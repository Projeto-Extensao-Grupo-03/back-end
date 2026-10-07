package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class MecanicoNaoExiste extends RuntimeException {
    public MecanicoNaoExiste(String message) {
        super(message);
    }
}
