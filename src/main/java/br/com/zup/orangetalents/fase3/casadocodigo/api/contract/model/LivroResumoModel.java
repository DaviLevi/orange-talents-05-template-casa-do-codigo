package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

public class LivroResumoModel {
	
	private Long id;
	
	private String titulo;

	public LivroResumoModel(Long id, String titulo) {
		super();
		this.id = id;
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}
