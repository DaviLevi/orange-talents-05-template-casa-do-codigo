package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.cliente.Cliente;

public class ClienteModel {

	private Long id;
	
	public ClienteModel(Cliente cliente) {
		this.id = cliente.getId();
	}

	public Long getId() {
		return id;
	}
}
