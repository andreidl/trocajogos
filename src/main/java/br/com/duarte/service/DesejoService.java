package br.com.duarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Desejo;
import br.com.duarte.repository.DesejoRepository;

@Service
public class DesejoService {

	@Autowired
	private DesejoRepository repository;

	public List<Desejo> findAll() {
		return (List<Desejo>) repository.findAll();
	}

	public Desejo findOne(Long id) {
		return repository.findOne(id);
	}

	public Desejo save(Desejo desejo) {
		return repository.save(desejo);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}
