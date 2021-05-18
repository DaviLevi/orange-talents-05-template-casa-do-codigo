package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LivroDetalheModel {
	
	private String titulo;
	
	private String resumo;
	
	private String sumario;
	
	private BigDecimal preco;
	
	private Integer paginas;	
	
	private String isbn;
	
	private LocalDate dataPublicacao;
	
	private AutorModel autor;

	public LivroDetalheModel(String titulo, String resumo, String sumario, BigDecimal preco, Integer paginas,
			String isbn, LocalDate dataPublicacao, AutorModel autor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
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

	public AutorModel getAutor() {
		return autor;
	}
	
	
	
}
