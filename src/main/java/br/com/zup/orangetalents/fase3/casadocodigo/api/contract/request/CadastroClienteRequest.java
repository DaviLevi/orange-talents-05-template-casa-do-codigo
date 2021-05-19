package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.cliente.Cliente;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.Estado;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.Pais;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.CnpjOuCpf;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.IdExistente;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.Unico;


public class CadastroClienteRequest {

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String sobrenome;
	
	@CnpjOuCpf
	@NotBlank
	@Unico(classeDominio = Cliente.class, nomeCampo = "documento")
	private String documento;
	
	@NotBlank
	private String endereco;
	
	@NotBlank
	private String complemento;
	
	@NotBlank
	private String cidade;
	
	@NotNull
	@IdExistente(classeDominio = Pais.class, nomeCampo = "id")
	private Long paisId;
	
	private Long estadoId;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String cep;

	@Deprecated public CadastroClienteRequest() {}
	
	public CadastroClienteRequest(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
			String cidade, Long paisId, Long estadoId, String telefone, String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.paisId = paisId;
		this.estadoId = estadoId;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Cliente paraDominio() {
		Estado estado = estadoId == null ? null : new Estado(estadoId);
		return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento, this.cidade, new Pais(paisId), estado, this.telefone, this.cep);
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Long getEstadoId() {
		return estadoId;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}
	
	
}
