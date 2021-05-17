package br.com.zup.orangetalents.fase3.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.CategoriaModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroCategoriaRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.Categoria;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	
	private final CategoriaRepository repositorio;
	
	public CategoriaController(CategoriaRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	@PostMapping
	@Transactional
	public CategoriaModel cadastrar(@Valid @RequestBody CadastroCategoriaRequest requisicao) {
		
		Categoria categoriaCadastrada = repositorio.save(requisicao.getDominio());
		
		return categoriaCadastrada.paraModel();
		
	}
	
}
