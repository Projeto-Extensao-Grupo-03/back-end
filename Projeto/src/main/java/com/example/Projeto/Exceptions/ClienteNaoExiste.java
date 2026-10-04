package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClienteNaoExiste extends RuntimeException {
    public ClienteNaoExiste(String message) {
        super(message);
    }
}
