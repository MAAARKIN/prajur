package br.com.prajur.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimento")
public class Movimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo")
	private int codigo;
	
	@OneToOne
	@JoinColumn(name = "tipoMovimento", referencedColumnName = "codigo")
	private TipoMovimento tipoMovimento;

	@Column(name="dataModificacao")
	private String dataModificacao;

	@ManyToOne
	@JoinColumn(name="codProcessoMovimento", referencedColumnName = "codigo")
	private Caso codProcessoMovimento;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}

	public Caso getCodigoProcesso() {
		return codProcessoMovimento;
	}

	public void setCodigoProcesso(Caso codigoProcesso) {
		this.codProcessoMovimento = codigoProcesso;
	}

	public String getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movimento other = (Movimento) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
}
