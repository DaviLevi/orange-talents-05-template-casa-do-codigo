package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.Pais;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.Unico;

public class CadastroPaisRequest {

	@NotBlank
	@Unico(nomeCampo = "nome", classeDominio = Pais.class)
	private String nome;
	
	@Deprecated public CadastroPaisRequest() {}
	
	public CadastroPaisRequest(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public Pais paraDominio() {
		return new Pais(nome);
	}
}
