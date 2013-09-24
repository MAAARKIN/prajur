package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.TipoProcedimentoFacade;
import br.com.prajur.modelo.TipoMovimento;
import br.com.prajur.modelo.TipoProcedimento;

@ManagedBean(name="tipoProcBean")
@ViewScoped
public class TipoProcedimentoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4402727905982798761L;
	private TipoProcedimento tipoProc;
	private List<TipoProcedimento> listar;
	
	public TipoProcedimentoBean() {
		this.tipoProc = new TipoProcedimento();
	}
	
	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		TipoProcedimentoFacade tipoProcRN = new TipoProcedimentoFacade();
		if(isUnico(this.tipoProc.getDescricao()) == false) {
			FacesMessage facesMessage = new FacesMessage("Impossível","Procedimento já Cadastrado!");
			context.addMessage(null, facesMessage);
			this.tipoProc = new TipoProcedimento();
			return null;
		}
		tipoProcRN.salvar(this.tipoProc);
		FacesMessage facesMessage = new FacesMessage("Concluído","Procedimento Cadastrado!");
		context.addMessage(null, facesMessage);
		this.tipoProc = new TipoProcedimento();
		return null;		
	}
	
	public String excluir() {
		TipoProcedimentoFacade tipoProcRN = new TipoProcedimentoFacade();
		tipoProcRN.excluir(this.tipoProc);
		this.tipoProc = new TipoProcedimento();
		return null;		
	}
	
	public void clean() {
		this.tipoProc = new TipoProcedimento();
	}

	public List<TipoProcedimento> getListar() {
		TipoProcedimentoFacade tipoProcRN = new TipoProcedimentoFacade();
		return this.listar = tipoProcRN.listar();
	}

	public TipoProcedimento getTipoProc() {
		return tipoProc;
	}

	public void setTipoProc(TipoProcedimento tipoProc) {
		this.tipoProc = tipoProc;
	}
	
	public boolean isUnico(String nome) {
		for(TipoProcedimento tp : listar) {
			if(tp.getDescricao().toLowerCase().equals(nome.toLowerCase())) {
				return false;
			}
		}
		return true;
	}
	
}