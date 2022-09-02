package br.com.otima.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentificacaoConstraintImpl implements ConstraintValidator<IdentificacaoConstraint, String> {

    @Override
    public void initialize(IdentificacaoConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String identificacao, ConstraintValidatorContext constraintValidatorContext) {
        if(identificacao == null || identificacao.trim().isEmpty() || identificacao.contains(" ")){
            return false;
        }
        return true;
    }
}
