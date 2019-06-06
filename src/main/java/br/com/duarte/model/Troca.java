package br.com.duarte.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Troca implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	         
	private String jogoSolicitado;
	private String jogoSolicitante;
	private String aceiteInicial;
	private String aceiteFinal;
	private String idSolicitante;
	private String idSolicitado;
	private String dataTroca;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getJogoSolicitado() {
		return jogoSolicitado;
	}

	public void setJogoSolicitado(String jogoSolicitado) {
		this.jogoSolicitado = jogoSolicitado;
	}

	public String getJogoSolicitante() {
		return jogoSolicitante;
	}

	public void setJogoSolicitante(String jogoSolicitante) {
		this.jogoSolicitante = jogoSolicitante;
	}

	public String getAceiteInicial() {
		return aceiteInicial;
	}

	public void setAceiteInicial(String aceiteInicial) {
		this.aceiteInicial = aceiteInicial;
	}

	public String getAceiteFinal() {
		return aceiteFinal;
	}

	public void setAceiteFinal(String aceiteFinal) {
		this.aceiteFinal = aceiteFinal;
	}

	public String getDataTroca() {
		return dataTroca;
	}

	public void setDataTroca(String dataTroca) {
		this.dataTroca = dataTroca;
	}

	

}
