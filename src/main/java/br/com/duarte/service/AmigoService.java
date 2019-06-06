package br.com.duarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Amigo;
import br.com.duarte.repository.AmigoRepository;

@Service
public class AmigoService {

	@Autowired
	private AmigoRepository repository;

	public List<Amigo> findAll() {
		return (List<Amigo>) repository.findAll();
	}

	public Amigo findOne(Long id) {
		return repository.findOne(id);
	}

	public Amigo save(Amigo amigo) {
		return repository.save(amigo);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}
