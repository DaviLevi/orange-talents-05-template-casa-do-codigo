package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro.Livro;

public class LivroResumoModel {
	
	private Long id;
	
	private String titulo;

	public LivroResumoModel(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}
