package br.com.prajur.bean;

import java.io.Serializable;
import java.sql.BatchUpdateException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import br.com.prajur.facade.TipoMovimentoFacade;
import br.com.prajur.modelo.TipoMovimento;


@ManagedBean(name="tipoMovimentoBean")
@ViewScoped
public class TipoMovimentoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6477527894192728597L;
	private TipoMovimento tipoMovimento;
	private List<TipoMovimento> listar;
	
	public TipoMovimentoBean() {
		this.tipoMovimento = new TipoMovimento();
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		TipoMovimentoFacade tipoMovRN = new TipoMovimentoFacade();
		if(isUnico(this.tipoMovimento.getDescricao()) == false) {
			FacesMessage facesMessage = new FacesMessage("Impossível","Movimento já Cadastrado!");
			context.addMessage(null, facesMessage);
			this.tipoMovimento = new TipoMovimento();
			return null;
		}
		tipoMovRN.salvar(this.tipoMovimento);
		FacesMessage facesMessage = new FacesMessage("Concluído","Movimento Cadastrado!");
		context.addMessage(null, facesMessage);
		this.tipoMovimento = new TipoMovimento();
		return null;		
	}
	
	public String excluir() {
		TipoMovimentoFacade tipoMovRN = new TipoMovimentoFacade();
		tipoMovRN.excluir(this.tipoMovimento);
		return null;		
	}
	
	public void clean() {
		this.tipoMovimento = new TipoMovimento();
	}

	public List<TipoMovimento> getListar() {
		TipoMovimentoFacade tipoMovRN = new TipoMovimentoFacade();
		return this.listar = tipoMovRN.listar();
	}

	public TipoMovimento getTipoMovimento() {
		return tipoMovimento;
	}

	public void setTipoMovimento(TipoMovimento tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	
	public boolean isUnico(String nome) {
		for(TipoMovimento tp : listar) {
			if(tp.getDescricao().toLowerCase().equals(nome.toLowerCase())) {
				return false;
			}
		}
		return true;
	}
	
}
