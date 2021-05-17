package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AutorID")
	private Long id;
	
	@Column(name = "Nome")
	@NotBlank
	private String nome;
	
	@Column(name = "Email", unique = true)
	@Email
	@NotBlank
	private String email;
	
	@Column(name = "Descricao", length = 400)
	@NotBlank @Size(max = 400)
	private String descricao;
	
	@CreationTimestamp
	@Column(name = "DataCadastro")
	private LocalDateTime dataCadastro;
	
	public Autor(@NotBlank String nome, @Email @NotBlank String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
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

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}
}
