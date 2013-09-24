package br.com.prajur.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import br.com.caelum.stella.ValidationMessage;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.prajur.facade.AssistidoFacade;
import br.com.prajur.facade.CidadeFacade;
import br.com.prajur.facade.EstadoFacade;
import br.com.prajur.modelo.Assistido;
import br.com.prajur.modelo.Cidade;
import br.com.prajur.modelo.Estado;
import br.com.prajur.util.ValidaCPF;

@ManagedBean(name="assistidoBean")
@ViewScoped
public class AssistidoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8915820456946485956L;
	private Assistido assistido;
	private List<Assistido> listar;
	private List<Estado> selecionarEstado = null;
	private List<Cidade> selecionarCidade;
	
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
		this.selecionarEstado = null;
		this.selecionarCidade = new ArrayList<Cidade>();
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
		this.selecionarEstado = null;
		this.selecionarCidade = new ArrayList<Cidade>();
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
		if(this.assistido.getEndereco().getCidade().getEstado().getCodigo() != 0) {
			CidadeFacade fornRN = new CidadeFacade();
			int n = this.assistido.getEndereco().getCidade().getEstado().getCodigo();
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
		int n = this.assistido.getEndereco().getCidade().getEstado().getCodigo();
		try {	    		
			this.selecionarCidade = estadoRN.listar(n);
		} catch (Throwable e) {
			e.printStackTrace();
		}      
	}
	
}
