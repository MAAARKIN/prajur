package br.com.prajur.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.prajur.facade.CidadeFacade;
import br.com.prajur.facade.EstadoFacade;
import br.com.prajur.facade.UsuarioFacade;
import br.com.prajur.modelo.Cidade;
import br.com.prajur.modelo.Estado;
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
	private List<Estado> selecionarEstado = null;
	private List<Cidade> selecionarCidade;
	
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
	
	public List<SelectItem> getSelecionarEstado() {
		if(this.selecionarEstado == null) {
			EstadoFacade estadoRN = new EstadoFacade();
			List<SelectItem> itens = new ArrayList<SelectItem>();
			itens.add(new SelectItem(null, "Selecione o estado"));
			try {
				for (Estado est : estadoRN.listar()) {
					SelectItem se = new SelectItem();
					se.setValue(est);
					se.setLabel(est.getSigla());
					itens.add(se);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return itens;
		} else {
			List<SelectItem> item = new ArrayList<SelectItem>();
			return item;
		}
	}

	public void setSelecionarEstado(List<Estado> selecionarEstado) {
		this.selecionarEstado = selecionarEstado;
	}

	public List<Cidade> getSelecionarCidade() {
		if(this.usuario.getEndereco().getCidade().getEstado().getCodigo() != 0) {
			CidadeFacade fornRN = new CidadeFacade();
			int n = this.usuario.getEndereco().getCidade().getEstado().getCodigo();
			try {	    		
				return this.selecionarCidade = fornRN.listar(n);
			} catch (Throwable e) {
				e.printStackTrace();
			}

		}
		return this.selecionarCidade;
	}

	public void setSelecionarCidade(List<Cidade> selecionarCidade) {
		this.selecionarCidade = selecionarCidade;
	}
	
	public void carregarCidades() {
		CidadeFacade estadoRN = new CidadeFacade();
		int n = this.usuario.getEndereco().getCidade().getEstado().getCodigo();
		try {	    		
			this.selecionarCidade = estadoRN.listar(n);
		} catch (Throwable e) {
			e.printStackTrace();
		}      
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
