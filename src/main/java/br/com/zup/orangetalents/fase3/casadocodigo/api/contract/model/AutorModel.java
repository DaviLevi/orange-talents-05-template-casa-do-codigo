package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.Autor;

public class AutorModel {
	
	private String nome;
	
	private String email;
	
	private String descricao;
	
	
	public AutorModel(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.descricao = autor.getDescricao();
	}


	public String getNome() {
		return nome;
	}


	public String getEmail() {
		return email;
	}


	public String getDescricao() {
		return descricao;
	}
	
	
}
