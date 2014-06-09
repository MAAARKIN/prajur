package br.com.prajur.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="caso")
public class Caso implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -289709935597443336L;

	@Id
	@GeneratedValue
	@Column(name = "codigo")
	private int codigo;
	
	@OneToMany(mappedBy="codProcessoProcedimento", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Procedimento> procedimento = new ArrayList<Procedimento>();
	
	@OneToMany(mappedBy="codProcessoMovimento", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	private List<Movimento> movimento = new ArrayList<Movimento>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codPasta", referencedColumnName = "codigo")
	private Pasta pasta;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="Caso_com_Professor", joinColumns={@JoinColumn(name="Caso_ID", referencedColumnName="codigo")}, inverseJoinColumns={@JoinColumn(name="Professor_ID", referencedColumnName="codigo")})
	private List<Professor> professor;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="Caso_com_Estagiario", joinColumns={@JoinColumn(name="Caso_ID", referencedColumnName="codigo")}, inverseJoinColumns={@JoinColumn(name="Estagiario_ID", referencedColumnName="codigo")})
	private List<Estagiario> estagiario;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinTable(name="Caso_com_Advogado", joinColumns={@JoinColumn(name="Caso_ID", referencedColumnName="codigo")}, inverseJoinColumns={@JoinColumn(name="Advogado_ID", referencedColumnName="codigo")})
	private List<Advogado> advogado;
	
	@Column(name="observacao")
	private String observacao;
	
	public Caso() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public List<Procedimento> getProcedimento() {
		Collections.reverse(this.procedimento);
		return procedimento;
	}
	
	public void setProcedimento(List<Procedimento> procedimento) {
		this.procedimento = procedimento;
	}

	public List<Movimento> getMovimento() {
		Collections.reverse(this.movimento);
		return movimento;
	}

	public void setMovimento(List<Movimento> movimento) {
		this.movimento = movimento;
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public List<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}

	public List<Estagiario> getEstagiario() {
		return estagiario;
	}

	public void setEstagiario(List<Estagiario> estagiario) {
		this.estagiario = estagiario;
	}

	public List<Advogado> getAdvogado() {
		return advogado;
	}

	public void setAdvogado(List<Advogado> advogado) {
		this.advogado = advogado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((advogado == null) ? 0 : advogado.hashCode());
		result = prime * result + codigo;
		result = prime * result
				+ ((estagiario == null) ? 0 : estagiario.hashCode());
		result = prime * result
				+ ((movimento == null) ? 0 : movimento.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + ((pasta == null) ? 0 : pasta.hashCode());
		result = prime * result
				+ ((procedimento == null) ? 0 : procedimento.hashCode());
		result = prime * result
				+ ((professor == null) ? 0 : professor.hashCode());
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
		Caso other = (Caso) obj;
		if (advogado == null) {
			if (other.advogado != null)
				return false;
		} else if (!advogado.equals(other.advogado))
			return false;
		if (codigo != other.codigo)
			return false;
		if (estagiario == null) {
			if (other.estagiario != null)
				return false;
		} else if (!estagiario.equals(other.estagiario))
			return false;
		if (movimento == null) {
			if (other.movimento != null)
				return false;
		} else if (!movimento.equals(other.movimento))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (pasta == null) {
			if (other.pasta != null)
				return false;
		} else if (!pasta.equals(other.pasta))
			return false;
		if (procedimento == null) {
			if (other.procedimento != null)
				return false;
		} else if (!procedimento.equals(other.procedimento))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		return true;
	}
	
	
	
}
