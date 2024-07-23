package com.wikeyspringboot.springboot03_demo01.validation;

import com.wikeyspringboot.springboot03_demo01.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @author: wikey
 * @create: 2024-07-21 12:00
 * @Description:
 */
public class StateValidation implements ConstraintValidator<State, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return false;
        }
        if (value.equals("publish") || value.equals("draft")) {
            return true;
        }
        return false;
    }
}