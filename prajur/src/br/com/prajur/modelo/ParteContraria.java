package br.com.prajur.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parteContraria")
public class ParteContraria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 408532797188079015L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@ManyToOne
	@JoinColumn(name="pastaContraria", referencedColumnName="codigo")
	private Pasta pastaContraria;
	
	public ParteContraria() {
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

	public Pasta getPastaContraria() {
		return pastaContraria;
	}

	public void setPastaContraria(Pasta pastaContraria) {
		this.pastaContraria = pastaContraria;
	}	
	
}