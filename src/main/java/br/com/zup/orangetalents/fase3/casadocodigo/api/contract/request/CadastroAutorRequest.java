package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.Autor;

public class CadastroAutorRequest {

	@NotBlank
	private String nome;
	
	@NotBlank
	@Email
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
