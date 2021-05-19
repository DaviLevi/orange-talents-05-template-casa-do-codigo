package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long>{

	
	@Query(value = "SELECT COUNT(e)"
	             + "FROM Estado e JOIN e.pais p where p.id = :id")
	Long contarQuantosEstadosPeloId(@Param(value = "id") Long id);
	
}
