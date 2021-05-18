package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PaisID")
	private Long id;
	
	@Column(name = "Nome", nullable = false, unique = true)
	private String nome;

	
	@Deprecated public Pais(){}
	
	public Pais(Long id) {
		this.id = id;
	}
	
	public Pais(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
