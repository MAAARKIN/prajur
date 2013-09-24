package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.EstagiarioFacade;
import br.com.prajur.modelo.Estagiario;

@ManagedBean(name="estagiarioBean")
@ViewScoped
public class EstagiarioBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6218497403595847885L;
	private Estagiario estagiario;
	private List<Estagiario> listar;
	private boolean disableNovo;
	
	public EstagiarioBean() {
		this.estagiario = new Estagiario();
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		EstagiarioFacade estRN = new EstagiarioFacade();
		estRN.salvar(this.estagiario);
		FacesMessage facesMessage = new FacesMessage("Estagiario Cadastrado!");
		context.addMessage(null, facesMessage);
		this.estagiario = new Estagiario();
		return null;		
	}
	
	public String excluir() {
		EstagiarioFacade estRN = new EstagiarioFacade();
		estRN.excluir(this.estagiario);
		return null;
	}

	public List<Estagiario> getListar() {
		EstagiarioFacade estRN = new EstagiarioFacade();
		return this.listar = estRN.listar();
	}

	public void setListar(List<Estagiario> listar) {
		this.listar = listar;
	}
	
	public void clean() {
		this.estagiario = new Estagiario();
	}

	public Estagiario getEstagiario() {
		return estagiario;
	}

	public void setEstagiario(Estagiario estagiario) {
		this.estagiario = estagiario;
	}

	public boolean isDisableNovo() {
		return disableNovo;
	}

	public void setDisableNovo(boolean disableNovo) {
		this.disableNovo = disableNovo;
	}
	

}
