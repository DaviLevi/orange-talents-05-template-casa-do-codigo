package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.CategoriaModel;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoriaID")
	private Long id;
	
	@NotBlank
	@Column(name = "Nome", unique = true)
	private String nome;
	
	@Deprecated
	public Categoria() {}

	
	public Categoria(Long id) {
		this.id = id;
	}
	
	public Categoria(String nome) {
		this.nome = nome;
	}
	
	public CategoriaModel paraModel() {
		return new CategoriaModel(nome);
	}

	public Long getId() {
		return this.id;
	}
	
}
