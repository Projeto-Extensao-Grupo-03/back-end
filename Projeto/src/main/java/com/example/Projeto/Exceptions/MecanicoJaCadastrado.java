package com.example.Projeto.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class MecanicoJaCadastrado extends RuntimeException {
    public MecanicoJaCadastrado(String message) {
        super(message);
    }
}
