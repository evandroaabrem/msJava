package br.com.otima.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdentificacaoConstraintImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IdentificacaoConstraint {
    String message() default "Invalid identificacao";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
