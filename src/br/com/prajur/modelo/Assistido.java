package br.com.prajur.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="assistido")
public class Assistido implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -452627832597178574L;

	@Id
	@GeneratedValue
	private int codigo;
	
	@OneToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="perfil", referencedColumnName="codigo")
	private Perfil perfil;
	
	@OneToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="endereco", referencedColumnName="codigo")
	private Endereco endereco;
	
	@OneToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="contato", referencedColumnName="codigo")
	private Contato contato;
	
	public Assistido() {
		this.perfil = new Perfil();
		this.endereco = new Endereco();
		this.contato = new Contato();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((contato == null) ? 0 : contato.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
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
		Assistido other = (Assistido) obj;
		if (codigo != other.codigo)
			return false;
		if (contato == null) {
			if (other.contato != null)
				return false;
		} else if (!contato.equals(other.contato))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		return true;
	}
	
}
