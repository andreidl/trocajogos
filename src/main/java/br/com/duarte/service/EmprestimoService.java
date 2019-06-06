package br.com.duarte.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.duarte.model.Emprestimo;
import br.com.duarte.repository.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repository;

	public List<Emprestimo> findAll() {
		return (List<Emprestimo>) repository.findAll();
	}

	public Emprestimo findOne(Long id) {
		return repository.findOne(id);
	}

	public Emprestimo save(Emprestimo emprestimo) {
		return repository.save(emprestimo);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

}
