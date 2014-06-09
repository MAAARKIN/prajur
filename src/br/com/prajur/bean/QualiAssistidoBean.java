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
import br.com.prajur.facade.QualiAssistidoFacade;
import br.com.prajur.modelo.Cidade;
import br.com.prajur.modelo.Estado;
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
	private List<Estado> selecionarEstado = null;
	private List<Cidade> selecionarCidade;
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
		this.selecionarEstado = null;
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Qualificação Cadastrada!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public String excluir() {
		QualiAssistidoFacade qualiRN = new QualiAssistidoFacade();
		qualiRN.excluir(qualiAssistido);
		this.qualiAssistido = new QualiAssistido();
		this.selecionarEstado = null;
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Qualificação Excluida!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public void clean() {
		this.qualiAssistido = new QualiAssistido();
		this.selecionarEstado = null;
	}

	public QualiAssistido getQualiAssistido() {
		return qualiAssistido;
	}

	public void setQualiAssistido(QualiAssistido qualiAssistido) {
		this.qualiAssistido = qualiAssistido;
	}
	
	public List<SelectItem> getSelecionarEstado() {
		if(this.selecionarEstado == null) {
			EstadoFacade estadoRN = new EstadoFacade();
			List<SelectItem> itens = new ArrayList<SelectItem>();
			itens.add(new SelectItem(null, "UF"));
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
		if(this.qualiAssistido.getEndereco().getCidade().getEstado().getCodigo() != 0) {
			CidadeFacade fornRN = new CidadeFacade();
			int n = this.qualiAssistido.getEndereco().getCidade().getEstado().getCodigo();
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
		int n = this.qualiAssistido.getEndereco().getCidade().getEstado().getCodigo();
		try {	    		
			this.selecionarCidade = estadoRN.listar(n);
		} catch (Throwable e) {
			e.printStackTrace();
		}      
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