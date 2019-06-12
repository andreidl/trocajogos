package br.com.duarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Usuario;
import br.com.duarte.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> findAll() {
		return (List<Usuario>) repository.findAll();
	}

	public Usuario findOne(Long id) {
		return repository.findOne(id);
	}

	public Usuario save(Usuario usuario) {
		return repository.save(usuario);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public Usuario findByLoginAndPassword(String login,String password) {
		return repository.findByLoginAndPassword(login,password);
	}
	
}
