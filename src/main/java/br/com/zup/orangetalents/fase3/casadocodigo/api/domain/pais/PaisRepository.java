package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

}
