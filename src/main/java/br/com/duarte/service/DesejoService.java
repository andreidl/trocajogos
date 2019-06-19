package br.com.duarte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.duarte.model.Desejo;
import br.com.duarte.repository.DesejoRepository;
import br.com.duarte.repository.DesejoSpecification;

@Service
public class DesejoService {

	@Autowired
	private DesejoRepository repository;

	public List<Desejo> findAll() {
		return (List<Desejo>) repository.findAll();
	}

	// TESTE NUMERO 1
	
	public List<Desejo> findAllByUser(){
		
		Desejo d1 = new Desejo();
		Long i = new Long(1);
		d1.setDsjIdUsuario(i); // teste mock
		
		Specification<Desejo> spec = new DesejoSpecification(d1);
		
		 List<Desejo> desejos = repository.findAll(spec);
		 return desejos;
	}
	
	// FIM TESTE NUMERO 1
	public Desejo findOne(Long id) {
		return repository.findOne(id);
	}

	public Desejo save(Desejo desejo) {
		return repository.save(desejo);
	}

	public void delete(Long id) {
		repository.delete(id);
	}

//	public Desejo findByUsuario(Long idUsuario){
//		return repository.findByUsuario(idUsuario);
//	}
}
