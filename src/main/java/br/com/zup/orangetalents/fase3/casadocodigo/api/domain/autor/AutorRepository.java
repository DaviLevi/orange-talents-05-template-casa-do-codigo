package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long>{

}
