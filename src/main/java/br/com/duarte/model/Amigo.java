package br.com.duarte.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@NamedQueries({
 //   @NamedQuery(name = "Empresa.findByCnpj", query = "Select e from Empresa e where e.cnpj = :cnpj ")
//})

public class Amigo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long amgId;	
	
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "user_id")
	private Usuario usuIdAmigoSolicitante;
	
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "user_id")
	private Usuario usuIdAmigoSolicitado;
	
	
	private String amgNome;
	private String amgDataInicio;
	
	public Long getAmgId() {
		return amgId;
	}
	public void setAmgId(Long amgId) {
		this.amgId = amgId;
	}
	public Usuario getUsuIdAmigoSolicitante() {
		return usuIdAmigoSolicitante;
	}
	public void setUsuIdAmigoSolicitante(Usuario usuIdAmigoSolicitante) {
		this.usuIdAmigoSolicitante = usuIdAmigoSolicitante;
	}
	public Usuario getUsuIdAmigoSolicitado() {
		return usuIdAmigoSolicitado;
	}
	public void setUsuIdAmigoSolicitado(Usuario usuIdAmigoSolicitado) {
		this.usuIdAmigoSolicitado = usuIdAmigoSolicitado;
	}
	public String getAmgNome() {
		return amgNome;
	}
	public void setAmgNome(String amgNome) {
		this.amgNome = amgNome;
	}
	public String getAmgDataInicio() {
		return amgDataInicio;
	}
	public void setAmgDataInicio(String amgDataInicio) {
		this.amgDataInicio = amgDataInicio;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	}
