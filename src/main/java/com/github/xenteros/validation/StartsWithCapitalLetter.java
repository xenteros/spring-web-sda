package com.github.xenteros.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StartsWithCapitalLetterValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StartsWithCapitalLetter {
    String message() default "Field must start with a capital letter.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}