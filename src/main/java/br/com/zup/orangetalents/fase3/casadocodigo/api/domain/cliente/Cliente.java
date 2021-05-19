package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.cliente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.Estado;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.Pais;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.CnpjOuCpf;

@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ClienteID")
	private Long id;
	
	@NotBlank
	@Email
	@Column(name = "Email", nullable = false, unique = true)
	private String email;
	
	@NotBlank
	@Column(name = "Nome", nullable = false)
	private String nome;
	
	@NotBlank
	@Column(name = "Sobrenome", nullable = false)
	private String sobrenome;
	
	@CnpjOuCpf
	@NotBlank
	@Column(name = "Documento", nullable = false, unique = true)
	private String documento;
	
	@NotBlank
	@Column(name = "Endereco", nullable = false)
	private String endereco;
	
	@NotBlank
	@Column(name = "Complemento", nullable = false)
	private String complemento;
	
	@NotBlank
	@Column(name = "Cidade", nullable = false)
	private String cidade;
	
	@NotNull
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(nullable = false, name = "PaisID")
	private Pais pais;
	
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(nullable = true, name = "EstadoID")
	private Estado estado;
	
	@NotBlank
	@Column(name = "Telefone", nullable = false)
	private String telefone;
	
	@NotBlank
	@Column(name = "Cep", nullable = false)
	private String cep;
	
	@Deprecated public Cliente() {}

	public Cliente(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
			@CnpjOuCpf @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotNull Pais pais, Estado estado, @NotBlank String telefone, @NotBlank String cep) {
		super();
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}
	
	public Long getId() {
		return id;
	}
	
}
