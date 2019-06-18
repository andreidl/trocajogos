package br.com.duarte.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Role;
import br.com.duarte.model.Usuario;
import br.com.duarte.repository.RoleRepository;
import br.com.duarte.repository.UsuarioRepository;

@Service
public class UsuarioService {

	private static UsuarioRepository usuarioRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<Usuario> findAll() {
		return (List<Usuario>) usuarioRepository.findAll();
	}

	public Usuario findOne(Long id) {
		return usuarioRepository.findOne(id);
	}

	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void delete(Long id) {
		usuarioRepository.delete(id);
	}

	public Usuario findUsuarioByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	public void saveUsuario(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuario.setActive(1);
		Role usuarioRole = roleRepository.findByRole("ADMIN");
		usuario.setRoles(new HashSet<Role>(Arrays.asList(usuarioRole)));
		usuarioRepository.save(usuario);
	}
}
