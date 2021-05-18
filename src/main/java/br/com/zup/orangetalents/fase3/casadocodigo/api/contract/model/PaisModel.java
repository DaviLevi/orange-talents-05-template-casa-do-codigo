package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.Pais;

public class PaisModel {
	
	private String nome;
	
	public PaisModel(Pais pais) {
		this.nome = pais.getNome();
	}
	
	public String getNome() {
		return nome;
	}
}
