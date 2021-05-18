package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.Estado;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.Pais;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.IdExistente;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.Unico;

public class CadastroEstadoRequest {

	@NotBlank
	@Unico(classeDominio = Estado.class, nomeCampo = "nome")
	private String nome;

	@IdExistente(classeDominio = Pais.class, nomeCampo = "id")
	@NotNull
	private Long paisId;

	public CadastroEstadoRequest(String nome, Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}
	
	public Estado getDominio() {
		return new Estado(nome, new Pais(paisId));
	}
}
