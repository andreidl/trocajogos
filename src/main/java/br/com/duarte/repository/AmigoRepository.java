package br.com.duarte.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.duarte.model.Amigo;

public interface AmigoRepository extends CrudRepository<Amigo, Long> {

}
