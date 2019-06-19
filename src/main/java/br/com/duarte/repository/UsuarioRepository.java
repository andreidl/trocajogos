package br.com.duarte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.duarte.model.Usuario;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "select login, senha, active from usuario where login=?", nativeQuery = true)
	public Usuario findByLogin(String login);

	@Query("SELECT login, senha, active FROM usuario u WHERE u.login = :login")
	public Usuario findByLoginAnother(@Param("login") String lastName);

}
