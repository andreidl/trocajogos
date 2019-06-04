package br.com.duarte.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.duarte.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
