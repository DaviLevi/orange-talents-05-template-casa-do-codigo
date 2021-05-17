package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroCategoriaRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.Categoria;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.CategoriaRepository;

@Component
public class ProibeNomeCategoriaDuplicadoValidator implements Validator{

	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroCategoriaRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if(errors.hasErrors())
			return;
		
		
		CadastroCategoriaRequest request = (CadastroCategoriaRequest) target;
		
		Optional<Categoria> categoria = categoriaRepositorio.findByNome(request.getNome());
		
		if(categoria.isPresent()) {
			errors.rejectValue("nome", null, "Já existe uma outra categoria com o mesmo nome");
		}
	}

	

}
