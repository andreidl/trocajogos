package br.com.duarte.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emprestimo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String dataDevolucao;
	private String dataDevolucaoEfetiva;
	private String dataEmprestimo;
	private String idSolicitante;	
	private String jogoEmprestado;
	private String idSolicitado;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getJogoEmprestado() {
		return jogoEmprestado;
	}

	public void setJogoEmprestado(String jogoEmprestado) {
		this.jogoEmprestado = jogoEmprestado;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getDataDevolucaoEfetiva() {
		return dataDevolucaoEfetiva;
	}

	public void setDataDevolucaoEfetiva(String dataDevolucaoEfetiva) {
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}

	public String getIdSolicitante() {
		return idSolicitante;
	}

	public void setIdSolicitante(String idSolicitante) {
		this.idSolicitante = idSolicitante;
	}

	public String getIdSolicitado() {
		return idSolicitado;
	}

	public void setIdSolicitado(String idSolicitado) {
		this.idSolicitado = idSolicitado;
	}

	

}
