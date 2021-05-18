package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	@Query(value = "SELECT l, a FROM Livro l JOIN l.autor a WHERE l.id = :id")
	Optional<Livro> buscaDetalheLivroPeloId(Long id);
	
}
