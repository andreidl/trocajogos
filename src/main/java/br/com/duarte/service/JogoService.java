package br.com.duarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Jogo;
import br.com.duarte.repository.JogoRepository;

@Service
public class JogoService {

	@Autowired
	private JogoRepository repository;

	public List<Jogo> findAll() {
		return (List<Jogo>) repository.findAll();
	}

	public Jogo findOne(Long id) {
		return repository.findOne(id);
	}

	public Jogo save(Jogo jogo) {
		return repository.save(jogo);
	}

	public void delete(Long id) {
		repository.delete(id);
	}
	
	public List<Jogo> findByUsuario(Long id) {
		return (List<Jogo>) repository.findByIdUsuario(id);
	}

}
