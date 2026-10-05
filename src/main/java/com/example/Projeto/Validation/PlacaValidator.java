package com.example.Projeto.Validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PlacaValidator implements ConstraintValidator<Placa, String> {

    @Override
    public boolean isValid(String placa, ConstraintValidatorContext context) {

        if (placa == null || placa.isBlank()) {
            return true;
        }

        String placaNormalizada = placa.toUpperCase().trim();

        String regex = "^[A-Z]{3}-?[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$";

        return placaNormalizada.matches(regex);
    }
}