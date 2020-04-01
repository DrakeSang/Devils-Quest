package com.DevilsQuest.app.validation.auth.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {
    @Override
    public boolean isValid(String email, ConstraintValidatorContext ctx) {
        final String regex = "^([a-zA-Z0-9]+(?:[._+-][a-zA-Z0-9]+)*)@([a-zA-Z]+)(?:[.-][a-zA-Z0-9]+)*[.]([a-zA-Z]{2,})$";

        if(email.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}