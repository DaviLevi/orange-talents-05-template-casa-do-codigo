package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdExistenteValidator implements ConstraintValidator<IdExistente, Long>{

	private Class<?> classeDominio;
	
	private String nomeCampo;
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void initialize(IdExistente constraintAnnotation) {
		this.classeDominio = constraintAnnotation.classeDominio();
		this.nomeCampo = constraintAnnotation.nomeCampo();
	}
	
	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		String jpql = String.format("SELECT a FROM %s a where a.%s = %d", this.classeDominio.getSimpleName(), this.nomeCampo, value);
		
		try {
			em.createQuery(jpql, this.classeDominio).getSingleResult();
			return true;
		}catch(NoResultException e) {
			return false;
		}
	}

}
