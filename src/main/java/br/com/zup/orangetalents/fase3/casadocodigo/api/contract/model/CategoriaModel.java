package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.Categoria;

public class CategoriaModel {

	private String nome;
	
	public CategoriaModel(Categoria categoria) {
		this.nome = categoria.getNome();
	}
	
	public CategoriaModel(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
}
