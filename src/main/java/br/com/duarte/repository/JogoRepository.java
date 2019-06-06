package br.com.duarte.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.duarte.model.Jogo;

public interface JogoRepository extends CrudRepository<Jogo, Long> {

}
