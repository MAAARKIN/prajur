package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.ParteContrariaFacade;
import br.com.prajur.modelo.ParteContraria;
import br.com.prajur.modelo.Pasta;

@ManagedBean(name="parteContrariaBean")
@ViewScoped
public class ParteContrariaBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5196028086503447478L;
	private Pasta pasta;
	private ParteContraria parte;
	private List<ParteContraria> listar;
	private boolean showExcluirButton;
	
	public ParteContrariaBean() {
		this.pasta = new Pasta();
		this.parte = new ParteContraria();
	}
	
	public String salvar() {
		parte.setPastaContraria(this.pasta);
		ParteContrariaFacade parteRN = new ParteContrariaFacade();
		parteRN.salvar(parte);
		this.parte = new ParteContraria();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Parte Contraria Cadastrada!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public String excluir() {
		ParteContrariaFacade parteRN = new ParteContrariaFacade();
		parteRN.excluir(parte);
		this.parte = new ParteContraria();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Parte Contraria Excluida!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public void clean() {
		this.parte = new ParteContraria();
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public ParteContraria getParte() {
		return parte;
	}

	public void setParte(ParteContraria parte) {
		this.parte = parte;
	}
		
	public boolean isShowExcluirButton() {
		if(this.parte.getCodigo() == 0) {
			return this.showExcluirButton = true;
		} else {			
			return this.showExcluirButton = false;
		}
	}

	public void setShowExcluirButton(boolean showExcluirButton) {
		this.showExcluirButton = showExcluirButton;
	}

	public List<ParteContraria> getListar() {
		ParteContrariaFacade parteRN = new ParteContrariaFacade();
		return this.listar = parteRN.listar(this.pasta.getCodigo());
	}	
	
}