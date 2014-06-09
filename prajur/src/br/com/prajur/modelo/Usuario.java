package br.com.prajur.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="usuario")
@SequenceGenerator(name = "usuario_sec", sequenceName = "usuario_sec", initialValue=15, allocationSize=1)
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1364050237321690125L;

	@Id
	@GeneratedValue(generator = "usuario_sec")
	private int codigo;

	@org.hibernate.annotations.NaturalId
	@Column(name="user_login", nullable=false)
	private String login;

	@Column(name="user_senha", nullable=false)
	private String senha;

	@Column(name="user_ativo", nullable=false)
	private boolean ativo;
	
	@ElementCollection(targetClass = String.class)
	@JoinTable(name="usuario_permissao", uniqueConstraints = {@UniqueConstraint(columnNames = {"usuario","permissao"})}, joinColumns = @JoinColumn(name = "usuario"))
	@Column(name="permissao", length=50)
	private Set<String> permissao = new HashSet<String>();
	
	@OneToOne(optional=true, cascade=CascadeType.ALL)
	@JoinColumn(name="perfil", referencedColumnName = "codigo")
	private Perfil perfil;

	public Usuario() {
		this.perfil = new Perfil();
	}

	public Set<String> getPermissao() {
		return permissao;
	}

	public void setPermissao(Set<String> permissao) {
		this.permissao = permissao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + codigo;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (ativo != other.ativo)
			return false;
		if (codigo != other.codigo)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
}