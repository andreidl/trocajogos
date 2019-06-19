package br.com.duarte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.duarte.model.Desejo;

@Repository
public interface DesejoRepository extends CrudRepository<Desejo, Long>, JpaSpecificationExecutor<Desejo> {

//	 @Query("SELECT dsjId, dsjIdUsuario, dsjNomeJogo, dsjDataRdgistroDesejo, dsjDescricaoJogo FROM Desejo WHERE dsjIdUsuario = ?")
//	 Desejo findByUsuario(Long idUsuario);
//	
	
}
