package br.com.zup.orangetalents.fase3.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.PaisModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroPaisRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.Pais;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {
	
	private final PaisRepository paisRepository;
	
	public PaisController(PaisRepository paisRepository) {
		this.paisRepository = paisRepository;
	}
	
	@PostMapping
	@Transactional
	public PaisModel cadastrar(@Valid @RequestBody CadastroPaisRequest requisicao){
		
		Pais paisCadastrado = paisRepository.save(requisicao.paraDominio());
		
		return new PaisModel(paisCadastrado);
	}
}
