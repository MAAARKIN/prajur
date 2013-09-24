package br.com.prajur.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.TriagemFacade;
import br.com.prajur.modelo.Pasta;
import br.com.prajur.modelo.Triagem;

@ManagedBean(name="triagemBean")
@ViewScoped
public class TriagemBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -277872565047052812L;
	private Triagem triagem;
	private Pasta pasta;
	private List<String> politicas = new ArrayList<String>();
	
	public TriagemBean() {
		this.triagem = new Triagem();
		this.pasta = new Pasta();
	}
	
	public String salvar() {
		TriagemFacade triRN = new TriagemFacade();
		this.triagem.setPoliticas(politicas);
		this.triagem.setCodPasta(pasta);
		triRN.atualizar(triagem);
		this.triagem = new Triagem();
		this.politicas = new ArrayList<String>();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Triagem Salva!");
		context.addMessage(null, facesMessage);
		return null;
	}

	public Triagem getTriagem() {
		return triagem;
	}

	public void setTriagem(Triagem triagem) {
		this.triagem = triagem;
	}
	
	public Triagem carregarTriagem() {
		TriagemFacade triRN = new TriagemFacade();
		this.triagem = triRN.carregarTriagem(pasta.getCodigo());
		return this.triagem;
	}

	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public List<String> getPoliticas() {
		TriagemFacade triRN = new TriagemFacade();
		return politicas = triRN.listarPoliticas(triagem.getCodigo());			
	}

	public void setPoliticas(List<String> politicas) {
		this.politicas = politicas;
	}

}
