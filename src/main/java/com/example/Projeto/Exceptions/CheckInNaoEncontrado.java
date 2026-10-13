package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CheckInNaoEncontrado extends RuntimeException {
    public CheckInNaoEncontrado(String message) {
        super(message);
    }
}
