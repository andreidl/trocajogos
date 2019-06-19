package br.com.duarte.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Desejo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dsjId;

	//@Column(name = "dsj_nome_jogo")
	private String dsjNomeJogo;
	private Long dsjIdUsuario;
	private String dsjDataRegistroDesejo;
	private String dsjDescricaoJogo;

	public Long getDsjId() {
		return dsjId;
	}

	public void setDsjId(Long dsjId) {
		this.dsjId = dsjId;
	}

	public String getDsjNomeJogo() {
		return dsjNomeJogo;
	}

	public void setDsjNomeJogo(String dsjNomeJogo) {
		this.dsjNomeJogo = dsjNomeJogo;
	}

	public String getDsjDataRegistroDesejo() {
		return dsjDataRegistroDesejo;
	}

	public void setDsjDataRegistroDesejo(String dsjDataRegistroDesejo) {
		this.dsjDataRegistroDesejo = dsjDataRegistroDesejo;
	}

	public String getDsjDescricaoJogo() {
		return dsjDescricaoJogo;
	}

	public void setDsjDescricaoJogo(String dsjDescricaoJogo) {
		this.dsjDescricaoJogo = dsjDescricaoJogo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getDsjIdUsuario() {
		return dsjIdUsuario;
	}

	public void setDsjIdUsuario(Long dsjIdUsuario) {
		this.dsjIdUsuario = dsjIdUsuario;
	}


}
