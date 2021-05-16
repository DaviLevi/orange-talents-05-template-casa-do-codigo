package br.com.zup.orangetalents.fase3.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.AutorModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroAutorRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.Autor;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.AutorRepository;

@RestController
@RequestMapping("/autores")
public class AutorController {

	private final AutorRepository autorRepository;
	
	public AutorController(AutorRepository autorRepository) {
		this.autorRepository = autorRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorModel> cadastrar(@Valid @RequestBody CadastroAutorRequest request){
		
		Autor autorCadastrado = autorRepository.save(request.getDominio());
		
		AutorModel model = new AutorModel(autorCadastrado);
		
		return ResponseEntity.ok(model);
	}
	
	
}
