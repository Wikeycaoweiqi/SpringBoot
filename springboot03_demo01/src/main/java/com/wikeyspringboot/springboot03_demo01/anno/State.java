package com.wikeyspringboot.springboot03_demo01.anno;

import com.wikeyspringboot.springboot03_demo01.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {StateValidation.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface State {
    String message() default "state must be publish or draft";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}