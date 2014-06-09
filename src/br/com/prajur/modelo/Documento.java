package br.com.prajur.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="documento")
public class Documento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1341540089660905706L;

	@Id
	@GeneratedValue
	private int codigo;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="CodigoPasta", referencedColumnName="codigo")
	private Pasta codPasta;
	
	public Documento() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pasta getCodPasta() {
		return codPasta;
	}

	public void setCodPasta(Pasta codPasta) {
		this.codPasta = codPasta;
	}

}
