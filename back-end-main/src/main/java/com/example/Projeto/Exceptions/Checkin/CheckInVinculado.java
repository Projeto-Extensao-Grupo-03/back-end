package com.example.Projeto.Exceptions.Checkin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class CheckInVinculado extends RuntimeException {
    public CheckInVinculado(String message) {
        super(message);
    }
}
