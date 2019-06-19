package br.com.duarte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.duarte.model.Emprestimo;
import br.com.duarte.model.Jogo;
import br.com.duarte.model.Usuario;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
	
//	public List<Jogo> findByIdSolicitante(Long id);

}
