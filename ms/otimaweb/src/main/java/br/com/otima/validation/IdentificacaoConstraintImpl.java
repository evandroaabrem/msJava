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
        Boolean result = Boolean.TRUE;

        if(identificacao == null || identificacao.trim().isEmpty() || identificacao.contains(" ")){
            result = Boolean.FALSE;
        }

        return result;
    }
}
