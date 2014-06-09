package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.AssistidoFacade;
import br.com.prajur.modelo.Assistido;

@ManagedBean(name="assistidoBean")
@ViewScoped
public class AssistidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8915820456946485956L;
	private Assistido assistido;
	private List<Assistido> listar;
	
	public AssistidoBean() {
		this.assistido = new Assistido();
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		AssistidoFacade assRN = new AssistidoFacade();
		assRN.salvar(this.assistido);
		FacesMessage facesMessage = new FacesMessage("Assistido Cadastrado!");
		context.addMessage(null, facesMessage);
		this.assistido = new Assistido();
		return null;		
	}
	
	public String excluir() {
		AssistidoFacade assRN = new AssistidoFacade();
		assRN.excluir(this.assistido);
		this.assistido = new Assistido();
		return null;		
	}
	
	public void clean() {
		this.assistido = new Assistido();
	}

	public Assistido getAssistido() {
		return assistido;
	}

	public void setAssistido(Assistido assistido) {
		this.assistido = assistido;
	}

	public List<Assistido> getListar() {
		AssistidoFacade assRN = new AssistidoFacade();
		return this.listar = assRN.listar();
	}
	
}
