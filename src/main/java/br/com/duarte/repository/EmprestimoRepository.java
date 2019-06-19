package br.com.duarte.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.duarte.model.Emprestimo;

public interface EmprestimoRepository extends CrudRepository<Emprestimo, Long> {

		
}
