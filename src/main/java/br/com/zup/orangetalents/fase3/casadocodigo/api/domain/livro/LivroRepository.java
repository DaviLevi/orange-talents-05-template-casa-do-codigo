package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}
