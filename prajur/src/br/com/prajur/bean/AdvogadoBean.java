package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import br.com.prajur.facade.AdvogadoFacade;
import br.com.prajur.modelo.Advogado;

@ManagedBean(name="advogadoBean")
@ViewScoped
public class AdvogadoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8194639821318976501L;
	private Advogado advogado;
	private List<Advogado> listar;

	public AdvogadoBean() {
		this.advogado = new Advogado();
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		AdvogadoFacade advRN = new AdvogadoFacade();
		advRN.salvar(this.advogado);
		FacesMessage facesMessage = new FacesMessage("Advogado Cadastrado!");
		context.addMessage(null, facesMessage);
		this.advogado = new Advogado();
		return null;		
	}

	public String excluir() {
		AdvogadoFacade advRN = new AdvogadoFacade();
		advRN.excluir(this.advogado);
		this.advogado = new Advogado();
		return null;		
	}

	public void clean() {
		this.advogado = new Advogado();
	}

	public List<Advogado> getListar() {
		AdvogadoFacade advRN = new AdvogadoFacade();
		return this.listar = advRN.listar();	
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}


}
