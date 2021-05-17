package br.com.zup.orangetalents.fase3.casadocodigo.api.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.LivroModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroLivroRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro.Livro;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro.LivroRepository;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	private final LivroRepository livroRepository;
	
	public LivroController(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroModel> cadastrar(@Valid @RequestBody CadastroLivroRequest requisicao){
		
		Livro livroCadastrado = livroRepository.save(requisicao.getDominio());
		
		return ResponseEntity.ok(livroCadastrado.paraModelo());
	}
	
	
}