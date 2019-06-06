package br.com.duarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Dialogo;
import br.com.duarte.repository.DialogoRepository;

@Service
public class DialogoService {

	@Autowired
	private DialogoRepository repository;

	public List<Dialogo> findAll() {
		return (List<Dialogo>) repository.findAll();
	}

	public Dialogo findOne(Long id) {
		return repository.findOne(id);
	}

	public Dialogo save(Dialogo dialogo) {
		return repository.save(dialogo);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}
