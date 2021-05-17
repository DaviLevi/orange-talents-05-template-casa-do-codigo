package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UnicoValidator implements ConstraintValidator<Unico, String>{

	private Class<?> classeDominio;
	
	private String nomeCampo;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(Unico constraintAnnotation) {
		this.classeDominio = constraintAnnotation.classeDominio();
		this.nomeCampo = constraintAnnotation.nomeCampo();
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String jpql = String.format("SELECT a FROM %s a where a.%s = '%s'", this.classeDominio.getSimpleName(), this.nomeCampo, value);
		
		try {
			em.createQuery(jpql, this.classeDominio).getSingleResult();
			return false;
		}catch(NoResultException e) {
			return true;
		}
	}

}
