package br.com.prajur.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="pasta")
@SequenceGenerator(name = "pasta_sec", sequenceName = "pasta_sec", allocationSize=1)  
public class Pasta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1103345756179617059L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "pasta_sec")
	private int codigo;
	
	@OneToOne
	@JoinColumn(name="assistido", referencedColumnName="codigo")
	private Assistido assistido;
	
	@OneToMany(mappedBy="codPasta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Documento> documentos;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="codPasta", fetch = FetchType.LAZY)
	@JoinColumn(name="triagem", referencedColumnName="codigo")
	private Triagem triagem;
	
	@OneToMany(mappedBy="pastaAssistido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<QualiAssistido> qualiAssistidos;
	
	@OneToMany(mappedBy="pastaContraria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ParteContraria> partesContrarias;
	
	@Column(name="data")
	private String data;
	
	@Column(name="contemCaso")
	private boolean contemCaso;
	
	public Pasta() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Assistido getAssistido() {
		return assistido;
	}

	public void setAssistido(Assistido assistido) {
		this.assistido = assistido;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public Triagem getTriagem() {
		return triagem;
	}

	public void setTriagem(Triagem triagem) {
		this.triagem = triagem;
	}

	public List<QualiAssistido> getQualiAssistidos() {
		return qualiAssistidos;
	}

	public void setQualiAssistidos(List<QualiAssistido> qualiAssistidos) {
		this.qualiAssistidos = qualiAssistidos;
	}

	public List<ParteContraria> getPartesContrarias() {
		return partesContrarias;
	}

	public void setPartesContrarias(List<ParteContraria> partesContrarias) {
		this.partesContrarias = partesContrarias;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isContemCaso() {
		return contemCaso;
	}

	public void setContemCaso(boolean contemCaso) {
		this.contemCaso = contemCaso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((assistido == null) ? 0 : assistido.hashCode());
		result = prime * result + codigo;
		result = prime * result + (contemCaso ? 1231 : 1237);
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((documentos == null) ? 0 : documentos.hashCode());
		result = prime
				* result
				+ ((partesContrarias == null) ? 0 : partesContrarias.hashCode());
		result = prime * result
				+ ((qualiAssistidos == null) ? 0 : qualiAssistidos.hashCode());
		result = prime * result + ((triagem == null) ? 0 : triagem.hashCode());
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
		Pasta other = (Pasta) obj;
		if (assistido == null) {
			if (other.assistido != null)
				return false;
		} else if (!assistido.equals(other.assistido))
			return false;
		if (codigo != other.codigo)
			return false;
		if (contemCaso != other.contemCaso)
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (documentos == null) {
			if (other.documentos != null)
				return false;
		} else if (!documentos.equals(other.documentos))
			return false;
		if (partesContrarias == null) {
			if (other.partesContrarias != null)
				return false;
		} else if (!partesContrarias.equals(other.partesContrarias))
			return false;
		if (qualiAssistidos == null) {
			if (other.qualiAssistidos != null)
				return false;
		} else if (!qualiAssistidos.equals(other.qualiAssistidos))
			return false;
		if (triagem == null) {
			if (other.triagem != null)
				return false;
		} else if (!triagem.equals(other.triagem))
			return false;
		return true;
	}
	
	

}
