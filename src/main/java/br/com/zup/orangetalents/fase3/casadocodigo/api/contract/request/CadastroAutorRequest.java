package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.Autor;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.Unico;

public class CadastroAutorRequest {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
	@Unico(nomeCampo = "email", classeDominio = Autor.class)
	private String email;
	
	@NotBlank
	@Size(min = 0, max = 400)
	private String descricao;
	
	public CadastroAutorRequest(String nome, String email,
			String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
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
	
	public Autor getDominio() {
		return new Autor(this.nome, this.email, this.descricao);
	}
}
