package br.com.duarte.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.duarte.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("SELECT user FROM Usuario user WHERE user.login=:login and user.senha=:password")
	Usuario findByLoginAndPassword(String login,String password);

}
