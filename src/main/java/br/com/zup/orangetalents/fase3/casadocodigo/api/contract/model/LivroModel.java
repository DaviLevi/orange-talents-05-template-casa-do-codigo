package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro.Livro;

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

	public LivroModel(Livro livro) {
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autorId = livro.getAutor().getId();
		this.categoriaId = livro.getCategoria().getId();
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
