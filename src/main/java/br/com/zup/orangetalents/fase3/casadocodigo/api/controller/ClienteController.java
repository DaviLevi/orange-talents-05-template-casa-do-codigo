package br.com.zup.orangetalents.fase3.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.ClienteModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroClienteRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.cliente.Cliente;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.cliente.ClienteRepository;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.ProibeEstadoIdNuloOuInexistenteSePaisIdTiverFilhosValidator;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProibeEstadoIdNuloOuInexistenteSePaisIdTiverFilhosValidator validadorEstadoId;
	
	@InitBinder
	public void inicializa(WebDataBinder binder) {
		binder.addValidators(validadorEstadoId);
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteModel> cadastrar(@Valid @RequestBody CadastroClienteRequest requisicao){
		
		Cliente clienteCadastrado = clienteRepository.save(requisicao.paraDominio());
		
		return ResponseEntity.ok(new ClienteModel(clienteCadastrado));
	}
	
	
	
}
