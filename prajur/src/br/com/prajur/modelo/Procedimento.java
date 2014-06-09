package br.com.prajur.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="procedimento")
public class Procedimento implements Serializable {

	
	private static final long serialVersionUID = 7343336717541309844L;

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;
	
	@OneToOne
	@JoinColumn(name = "tipoProcedimento" , referencedColumnName = "codigo")
	private TipoProcedimento tipoProcedimento;

	@ManyToOne
	@JoinColumn(name="codProcessoProcedimento", referencedColumnName="codigo")
	private Caso codProcessoProcedimento;
	
	@Column(name = "data_Mod" , nullable = false)
	private String dataModificacao;
	
	public Procedimento() {
		
	}

	public Procedimento(int codigo, String dataModificacao) {
		this.codigo = codigo;
		this.dataModificacao = dataModificacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public TipoProcedimento getTipoProcedimento() {
		return tipoProcedimento;
	}

	public void setTipoProcedimento(TipoProcedimento tipoProcedimento) {
		this.tipoProcedimento = tipoProcedimento;
	}

	public String getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(String dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	
	public Caso getCodProcessoProcedimento() {
		return codProcessoProcedimento;
	}

	public void setCodProcessoProcedimento(Caso codProcessoProcedimento) {
		this.codProcessoProcedimento = codProcessoProcedimento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result
				+ ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		result = prime
				* result
				+ ((tipoProcedimento == null) ? 0 : tipoProcedimento.hashCode());
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
		Procedimento other = (Procedimento) obj;
		if (codigo != other.codigo)
			return false;
		if (dataModificacao == null) {
			if (other.dataModificacao != null)
				return false;
		} else if (!dataModificacao.equals(other.dataModificacao))
			return false;
		if (tipoProcedimento == null) {
			if (other.tipoProcedimento != null)
				return false;
		} else if (!tipoProcedimento.equals(other.tipoProcedimento))
			return false;
		return true;
	}
	
	
	
}
