package br.com.duarte.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Troca;
import br.com.duarte.repository.TrocaRepository;

@Service
public class TrocaService {

	@Autowired
	private TrocaRepository repository;

	public List<Troca> findAll() {
		return (List<Troca>) repository.findAll();
	}

	public Troca findOne(Long id) {
		return repository.findOne(id);
	}

	public Troca save(Troca troca) {
		return repository.save(troca);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}
