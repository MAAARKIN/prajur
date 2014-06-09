package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.QualiAssistidoFacade;
import br.com.prajur.modelo.Pasta;
import br.com.prajur.modelo.QualiAssistido;

@ManagedBean(name="qualiAssistidoBean")
@ViewScoped
public class QualiAssistidoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8491460430481831292L;
	private Pasta pasta;
	private QualiAssistido qualiAssistido;
	private List<QualiAssistido> listar;
	private boolean showExcluirButton;
	
	public QualiAssistidoBean() {
		this.pasta = new Pasta();
		this.qualiAssistido = new QualiAssistido();
	}
	
	public String salvar() {
		qualiAssistido.setPastaAssistido(this.pasta);
		QualiAssistidoFacade qualiRN = new QualiAssistidoFacade();
		qualiRN.salvar(qualiAssistido);
		this.qualiAssistido = new QualiAssistido();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Qualificação Cadastrada!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public String excluir() {
		QualiAssistidoFacade qualiRN = new QualiAssistidoFacade();
		qualiRN.excluir(qualiAssistido);
		this.qualiAssistido = new QualiAssistido();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Qualificação Excluida!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public void clean() {
		this.qualiAssistido = new QualiAssistido();
	}

	public QualiAssistido getQualiAssistido() {
		return qualiAssistido;
	}

	public void setQualiAssistido(QualiAssistido qualiAssistido) {
		this.qualiAssistido = qualiAssistido;
	}

	public List<QualiAssistido> getListar() {
		QualiAssistidoFacade quali = new QualiAssistidoFacade();
		return this.listar = quali.listar(this.pasta.getCodigo());
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public boolean isShowExcluirButton() {
		if(this.qualiAssistido.getCodigo() == 0) {
			return this.showExcluirButton = true;
		} else {			
			return this.showExcluirButton = false;
		}
	}

	public void setShowExcluirButton(boolean showExcluirButton) {
		this.showExcluirButton = showExcluirButton;
	}
	
}