package com.github.xenteros.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class StartsWithCapitalLetterValidator implements ConstraintValidator<StartsWithCapitalLetter, String> {

    @Override
    public void initialize(StartsWithCapitalLetter constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && value.matches("[A-Z].*");
    }
}
