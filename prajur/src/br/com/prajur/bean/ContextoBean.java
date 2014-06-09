package br.com.prajur.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.UsuarioFacade;
import br.com.prajur.modelo.Usuario;

@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 588215802595059286L;
	private Usuario usuarioLogado = null;
	
	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		if (this.usuarioLogado == null || !login.equals(this.usuarioLogado.getLogin())) {

			if (login != null) {
				UsuarioFacade usuarioRN = new UsuarioFacade();
				this.usuarioLogado = usuarioRN.buscaPorLogin(login);
			}
		}
		return usuarioLogado;
	}
}
