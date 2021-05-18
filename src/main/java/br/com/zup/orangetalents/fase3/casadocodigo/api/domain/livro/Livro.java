package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.LivroModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.model.LivroResumoModel;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.Autor;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.categoria.Categoria;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LivroID")
	private Long id;
	
	@Column(name = "Titulo", nullable = false, unique = true)
	@NotBlank
	private String titulo;
	
	@Column(name = "Resumo", length = 500, nullable = false)
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	@Column(name = "Sumario")
	private String sumario;
	
	@Column(name = "Preco")
	@DecimalMin(value = "20")
	private BigDecimal preco;
	
	@Column(name = "Paginas", nullable = false)
	@Min(value = 100)
	private Integer paginas;
	
	@Column(name = "Isbn", nullable = false, unique = true)
	@NotBlank
	private String isbn;
	
	@Future
	private LocalDate dataPublicacao;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "AutorID")
	private Autor autor;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "CategoriaID")
	private Categoria categoria;
	
	@Deprecated public Livro(){}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@DecimalMin("20") BigDecimal preco, @Min(100) Integer paginas, @NotBlank String isbn,
			@Future LocalDate dataPublicacao, @NotNull Autor autor, @NotNull Categoria categoria) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.paginas = paginas;
		this.isbn = isbn;
		this.dataPublicacao = dataPublicacao;
		this.autor = autor;
		this.categoria = categoria;
	}
	
	public LivroModel paraModelo() {
		return new LivroModel(titulo, resumo, sumario, preco, paginas, isbn, dataPublicacao, autor.getId(), categoria.getId());
	}
	
	public LivroResumoModel paraResumoModelo() {
		return new LivroResumoModel(id, titulo);
	}
}
