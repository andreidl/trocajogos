package br.com.duarte.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.duarte.model.Desejo;

public class DesejoSpecification implements Specification<Desejo> {

	private Desejo desejo;
	
	public DesejoSpecification(Desejo desejo){
		super();
		this.desejo = desejo;
	}
	
	@Override
	public Predicate toPredicate(Root<Desejo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		Predicate pred = cb.disjunction();
		
		if (desejo.getDsjIdUsuario() != null){
			pred.getExpressions().add(cb.equal(root.get(""), desejo.getDsjIdUsuario()));
		}
		
		return pred;
	}

}
