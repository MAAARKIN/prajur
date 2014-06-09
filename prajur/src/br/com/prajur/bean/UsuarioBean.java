package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.UsuarioFacade;
import br.com.prajur.modelo.Usuario;

@ManagedBean(name="usuarioBean")
@ViewScoped
public class UsuarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3105447343739072193L;
	private Usuario usuario;
	private String confirmarSenha;
	private List<Usuario> lista = null;
	
	public UsuarioBean() {
		this.usuario = new Usuario();
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		String senha = this.usuario.getSenha();
		if(!senha.equals(this.confirmarSenha)) {
			FacesMessage facesMessage = new FacesMessage("A senha não foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null;
		}
		
		UsuarioFacade usuarioRN = new UsuarioFacade();
		usuarioRN.salvar(this.usuario);
		return null;
	}
	
	public String excluir() {
		UsuarioFacade usuarioRN = new UsuarioFacade();
		usuarioRN.excluir(this.usuario);
		return null;
	}
	
	public String ativar() {
		if(this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);
		
		UsuarioFacade usuarioRN = new UsuarioFacade();
		usuarioRN.salvar(this.usuario);
		return null;
	}
	
	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if(permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}
	
	public List<Usuario> getLista() {
		if(this.lista == null) {
			UsuarioFacade usuarioRN = new UsuarioFacade();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}
	
	public void clean() {
		this.usuario = new Usuario();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
