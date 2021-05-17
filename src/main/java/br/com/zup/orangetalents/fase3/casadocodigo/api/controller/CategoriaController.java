package br.com.zup.orangetalents.fase3.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.CategoriaModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroCategoriaRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.Categoria;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.CategoriaRepository;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.ProibeNomeCategoriaDuplicadoValidator;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	
	private final CategoriaRepository repositorio;
	
	private final ProibeNomeCategoriaDuplicadoValidator nomeValidator;
	
	public CategoriaController(CategoriaRepository repositorio, ProibeNomeCategoriaDuplicadoValidator nomeValidator) {
		this.repositorio = repositorio;
		this.nomeValidator = nomeValidator;
	}
	
	@InitBinder
	public void inicializa(WebDataBinder binder){
		binder.addValidators(nomeValidator);
	}
	
	@PostMapping
	@Transactional
	public CategoriaModel cadastrar(@Valid @RequestBody CadastroCategoriaRequest requisicao) {
		
		Categoria categoriaCadastrada = repositorio.save(requisicao.getDominio());
		
		return categoriaCadastrada.paraModel();
		
	}
	
}
