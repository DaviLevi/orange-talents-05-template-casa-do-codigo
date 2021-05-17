package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = { IdExistenteValidator.class })
public @interface IdExistente {
	
	String message() default "Esse campo deve ter uma entidade associada";
	
	Class<?> classeDominio();
	
	String nomeCampo();

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}
