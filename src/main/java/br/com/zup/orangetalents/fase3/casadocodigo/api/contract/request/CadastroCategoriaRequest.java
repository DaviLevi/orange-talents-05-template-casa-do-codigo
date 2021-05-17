package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request;

import javax.validation.constraints.NotBlank;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.Categoria;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.Unico;

public class CadastroCategoriaRequest {
	
	@NotBlank
	@Unico(nomeCampo = "nome", classeDominio = Categoria.class)
	private String nome;
	
	public CadastroCategoriaRequest() {}
	
	public CadastroCategoriaRequest(String nome) {
		this.nome = nome;
	}
	
	public Categoria getDominio() {
		return new Categoria(nome);
	}
	
	public String getNome() {
		return this.nome;
	}
}
