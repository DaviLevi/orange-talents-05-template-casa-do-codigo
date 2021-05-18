package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro.Livro;

public class LivroDetalheModel {
	
	private String titulo;
	
	private String resumo;
	
	private String sumario;
	
	private BigDecimal preco;
	
	private Integer paginas;	
	
	private String isbn;
	
	private LocalDate dataPublicacao;
	
	private AutorModel autor;

	public LivroDetalheModel(Livro livro) {
		super();
		this.titulo = livro.getTitulo();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.preco = livro.getPreco();
		this.paginas = livro.getPaginas();
		this.isbn = livro.getIsbn();
		this.dataPublicacao = livro.getDataPublicacao();
		this.autor = new AutorModel(livro.getAutor());
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
