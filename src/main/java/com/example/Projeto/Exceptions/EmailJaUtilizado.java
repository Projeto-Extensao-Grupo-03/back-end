package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class EmailJaUtilizado extends RuntimeException {
    public EmailJaUtilizado(String message) {
        super(message);
    }
}
