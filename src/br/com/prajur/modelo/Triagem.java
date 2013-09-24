package br.com.prajur.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="triagem")
public class Triagem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1916261623276035366L;

	@Id
	@GeneratedValue
	private int codigo;
	
	@OneToOne
	@JoinColumn(name="codPasta", referencedColumnName="codigo")
	private Pasta codPasta;
	
	@Column(name="data")
	private Date data;
	
	@Column(name="hora")
	private String hora;
	
	@Column(name="natureza")
	private String natureza;
	
	@Column(name="encaminhamento")
	private String encaminhamento;
	
	@Column(name="infoComplementar")
	private String infoComplementar;
	
	@Column(name="comoSoube")
	private String comoSoube;
	
	@Column(name="estadoCivil")
	private String estadoCivil;
	
	@Column(name="escolaridade")
	private String escolaridade;
	
	@Column(name="rendaFixa")
	private String rendaFixa;
	
	@Column(name="rendaComplementar")
	private String rendaComplementar;
	
	@Column(name="dependentes")
	private String dependentes;
	
	@Column(name="numDependentes")
	private String numDependentes;
	
	@Column(name="localidade")
	private String localidade;
	
	@Column(name="tipoImovel")
	private String tipoImovel;
	
	@Column(name="situacaoImovel")
	private String situacaoImovel;
	
	@Column(name="religiao")
	private String religiao;
	//Parte de Necessidades Especiais.
	@Column(name="necessidadeEspecial")
	private String necessidadeEspecial;
	
	@Column(name="especifique")
	private String especifique;
	
	@Column(name="grauParentesco")
	private String grauParentesco;
	
	@Column(name="dispesaMensal")
	private String dispesaMensal;
	
	@ElementCollection(targetClass = String.class)
	@JoinTable(name="triagem_politicas", uniqueConstraints = {@UniqueConstraint(columnNames = {"codigo","descricao"})}, joinColumns = @JoinColumn(name = "codigo"))
	@Column(name="descricao", length=50)
	private List<String> politicas;
	
	@Column(name="resultado")
	private String resultado;
	
	@Column(name="obeservacao")
	private String observacao;
	
	public Triagem() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Pasta getCodPasta() {
		return codPasta;
	}

	public void setCodPasta(Pasta codPasta) {
		this.codPasta = codPasta;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getNatureza() {
		return natureza;
	}

	public void setNatureza(String natureza) {
		this.natureza = natureza;
	}

	public String getEncaminhamento() {
		return encaminhamento;
	}

	public void setEncaminhamento(String encaminhamento) {
		this.encaminhamento = encaminhamento;
	}

	public String getInfoComplementar() {
		return infoComplementar;
	}

	public void setInfoComplementar(String infoComplementar) {
		this.infoComplementar = infoComplementar;
	}

	public String getComoSoube() {
		return comoSoube;
	}

	public void setComoSoube(String comoSoube) {
		this.comoSoube = comoSoube;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getEscolaridade() {
		return escolaridade;
	}

	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}

	public String getRendaFixa() {
		return rendaFixa;
	}

	public void setRendaFixa(String rendaFixa) {
		this.rendaFixa = rendaFixa;
	}

	public String getRendaComplementar() {
		return rendaComplementar;
	}

	public void setRendaComplementar(String rendaComplementar) {
		this.rendaComplementar = rendaComplementar;
	}

	public String getDependentes() {
		return dependentes;
	}

	public void setDependentes(String dependentes) {
		this.dependentes = dependentes;
	}

	public String getNumDependentes() {
		return numDependentes;
	}

	public void setNumDependentes(String numDependentes) {
		this.numDependentes = numDependentes;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getTipoImovel() {
		return tipoImovel;
	}

	public void setTipoImovel(String tipoImovel) {
		this.tipoImovel = tipoImovel;
	}

	public String getSituacaoImovel() {
		return situacaoImovel;
	}

	public void setSituacaoImovel(String situacaoImovel) {
		this.situacaoImovel = situacaoImovel;
	}

	public String getReligiao() {
		return religiao;
	}

	public void setReligiao(String religiao) {
		this.religiao = religiao;
	}

	public String getNecessidadeEspecial() {
		return necessidadeEspecial;
	}

	public void setNecessidadeEspecial(String nessecidadeEspecial) {
		this.necessidadeEspecial = nessecidadeEspecial;
	}

	public String getEspecifique() {
		return especifique;
	}

	public void setEspecifique(String especifique) {
		this.especifique = especifique;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getDispesaMensal() {
		return dispesaMensal;
	}

	public void setDispesaMensal(String dispesaMensal) {
		this.dispesaMensal = dispesaMensal;
	}

	public List<String> getPoliticas() {
		return politicas;
	}

	public void setPoliticas(List<String> politicas) {
		this.politicas = politicas;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
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
				+ ((codPasta == null) ? 0 : codPasta.hashCode());
		result = prime * result + codigo;
		result = prime * result
				+ ((comoSoube == null) ? 0 : comoSoube.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((dependentes == null) ? 0 : dependentes.hashCode());
		result = prime * result
				+ ((dispesaMensal == null) ? 0 : dispesaMensal.hashCode());
		result = prime * result
				+ ((encaminhamento == null) ? 0 : encaminhamento.hashCode());
		result = prime * result
				+ ((escolaridade == null) ? 0 : escolaridade.hashCode());
		result = prime * result
				+ ((especifique == null) ? 0 : especifique.hashCode());
		result = prime * result
				+ ((estadoCivil == null) ? 0 : estadoCivil.hashCode());
		result = prime * result
				+ ((grauParentesco == null) ? 0 : grauParentesco.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime
				* result
				+ ((infoComplementar == null) ? 0 : infoComplementar.hashCode());
		result = prime * result
				+ ((localidade == null) ? 0 : localidade.hashCode());
		result = prime * result
				+ ((natureza == null) ? 0 : natureza.hashCode());
		result = prime
				* result
				+ ((necessidadeEspecial == null) ? 0 : necessidadeEspecial
						.hashCode());
		result = prime * result
				+ ((numDependentes == null) ? 0 : numDependentes.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result
				+ ((politicas == null) ? 0 : politicas.hashCode());
		result = prime * result
				+ ((religiao == null) ? 0 : religiao.hashCode());
		result = prime
				* result
				+ ((rendaComplementar == null) ? 0 : rendaComplementar
						.hashCode());
		result = prime * result
				+ ((rendaFixa == null) ? 0 : rendaFixa.hashCode());
		result = prime * result
				+ ((resultado == null) ? 0 : resultado.hashCode());
		result = prime * result
				+ ((situacaoImovel == null) ? 0 : situacaoImovel.hashCode());
		result = prime * result
				+ ((tipoImovel == null) ? 0 : tipoImovel.hashCode());
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
		Triagem other = (Triagem) obj;
		if (codPasta == null) {
			if (other.codPasta != null)
				return false;
		} else if (!codPasta.equals(other.codPasta))
			return false;
		if (codigo != other.codigo)
			return false;
		if (comoSoube == null) {
			if (other.comoSoube != null)
				return false;
		} else if (!comoSoube.equals(other.comoSoube))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dependentes == null) {
			if (other.dependentes != null)
				return false;
		} else if (!dependentes.equals(other.dependentes))
			return false;
		if (dispesaMensal == null) {
			if (other.dispesaMensal != null)
				return false;
		} else if (!dispesaMensal.equals(other.dispesaMensal))
			return false;
		if (encaminhamento == null) {
			if (other.encaminhamento != null)
				return false;
		} else if (!encaminhamento.equals(other.encaminhamento))
			return false;
		if (escolaridade == null) {
			if (other.escolaridade != null)
				return false;
		} else if (!escolaridade.equals(other.escolaridade))
			return false;
		if (especifique == null) {
			if (other.especifique != null)
				return false;
		} else if (!especifique.equals(other.especifique))
			return false;
		if (estadoCivil == null) {
			if (other.estadoCivil != null)
				return false;
		} else if (!estadoCivil.equals(other.estadoCivil))
			return false;
		if (grauParentesco == null) {
			if (other.grauParentesco != null)
				return false;
		} else if (!grauParentesco.equals(other.grauParentesco))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (infoComplementar == null) {
			if (other.infoComplementar != null)
				return false;
		} else if (!infoComplementar.equals(other.infoComplementar))
			return false;
		if (localidade == null) {
			if (other.localidade != null)
				return false;
		} else if (!localidade.equals(other.localidade))
			return false;
		if (natureza == null) {
			if (other.natureza != null)
				return false;
		} else if (!natureza.equals(other.natureza))
			return false;
		if (necessidadeEspecial == null) {
			if (other.necessidadeEspecial != null)
				return false;
		} else if (!necessidadeEspecial.equals(other.necessidadeEspecial))
			return false;
		if (numDependentes == null) {
			if (other.numDependentes != null)
				return false;
		} else if (!numDependentes.equals(other.numDependentes))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (politicas == null) {
			if (other.politicas != null)
				return false;
		} else if (!politicas.equals(other.politicas))
			return false;
		if (religiao == null) {
			if (other.religiao != null)
				return false;
		} else if (!religiao.equals(other.religiao))
			return false;
		if (rendaComplementar == null) {
			if (other.rendaComplementar != null)
				return false;
		} else if (!rendaComplementar.equals(other.rendaComplementar))
			return false;
		if (rendaFixa == null) {
			if (other.rendaFixa != null)
				return false;
		} else if (!rendaFixa.equals(other.rendaFixa))
			return false;
		if (resultado == null) {
			if (other.resultado != null)
				return false;
		} else if (!resultado.equals(other.resultado))
			return false;
		if (situacaoImovel == null) {
			if (other.situacaoImovel != null)
				return false;
		} else if (!situacaoImovel.equals(other.situacaoImovel))
			return false;
		if (tipoImovel == null) {
			if (other.tipoImovel != null)
				return false;
		} else if (!tipoImovel.equals(other.tipoImovel))
			return false;
		return true;
	}

	
}
