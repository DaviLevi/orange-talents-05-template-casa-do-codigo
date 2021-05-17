package br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.Autor;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.Categoria;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro.Livro;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.IdExistente;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator.Unico;

public class CadastroLivroRequest {
	
	@NotBlank
	@Unico(nomeCampo = "titulo", classeDominio = Livro.class)
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@NotBlank
	private String sumario;
	
	@DecimalMin(value = "20")
	private BigDecimal preco;
	
	@Min(value = 100)
	private Integer paginas;
	
	@NotBlank
	@Unico(nomeCampo = "isbn", classeDominio = Livro.class)
	private String isbn;
	
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
	private LocalDate dataPublicacao;
	
	@IdExistente(classeDominio = Autor.class, nomeCampo = "id")
	private Long autorId;
	
	@IdExistente(classeDominio = Categoria.class, nomeCampo = "id")
	private Long categoriaId;

	@Deprecated public CadastroLivroRequest() {}
	
	public CadastroLivroRequest(String titulo, String resumo,
			String sumario, BigDecimal preco, Integer paginas,
			String isbn, LocalDate dataPublicacao, Long autorId, Long categoriaId) {
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
	
	public Livro getDominio() {
		return new Livro(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, new Autor(autorId), new Categoria(categoriaId));
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
