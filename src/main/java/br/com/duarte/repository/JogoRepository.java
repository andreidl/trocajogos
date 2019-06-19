package br.com.duarte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.duarte.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
	
	public List<Jogo> findByUsuario(Long id);
	
//	@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
 //   public List<Person> find(@Param("lastName") String lastName);

}
