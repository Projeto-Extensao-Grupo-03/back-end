package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ChecklistInvalido extends RuntimeException {
    public ChecklistInvalido(String message) {
        super(message);
    }
}
