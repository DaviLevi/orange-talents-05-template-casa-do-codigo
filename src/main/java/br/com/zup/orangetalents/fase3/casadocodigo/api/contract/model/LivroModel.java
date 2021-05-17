package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroModel {
	
	private String titulo;
	
	private String resumo;
	
	private String sumario;
	
	private BigDecimal preco;
	
	private Integer paginas;	
	
	private String isbn;
	
	private LocalDate dataPublicacao;
	
	private Long autorId;
	
	private Long categoriaId;

	public LivroModel(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas, String isbn,
			LocalDate dataPublicacao, Long autorId, Long categoriaId) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autorId = autorId;
		this.categoriaId = categoriaId;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public Integer getPaginas() {
		return paginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDataPublicacao() {
		return dataPublicacao;
	}

	public Long getAutorId() {
		return autorId;
	}

	public Long getCategoriaId() {
		return categoriaId;
	}
	
	
	
}
