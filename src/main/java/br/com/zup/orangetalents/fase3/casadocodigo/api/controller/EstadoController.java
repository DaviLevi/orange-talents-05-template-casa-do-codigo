package br.com.zup.orangetalents.fase3.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.EstadoModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroEstadoRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.Estado;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	private final EstadoRepository estadoRepository;
	
	public EstadoController(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}
	
	@PostMapping
	@Transactional
	public EstadoModel cadastrar(@Valid @RequestBody CadastroEstadoRequest requisicao){
		
		Estado estadoCadastrado = estadoRepository.save(requisicao.getDominio());
		
		return new EstadoModel(estadoCadastrado);
	}
}

