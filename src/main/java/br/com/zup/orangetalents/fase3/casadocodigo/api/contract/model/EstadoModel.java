package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.Estado;

public class EstadoModel {

	private String nome;
	
	private Long paisId;

	public EstadoModel(Estado estado) {
		this.nome = estado.getNome();
		this.paisId = estado.getPais().getId();
	}
	
	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}
	
	
	
}
