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
import br.com.prajur.facade.ParteContrariaFacade;
import br.com.prajur.modelo.Cidade;
import br.com.prajur.modelo.Estado;
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
	private List<Estado> selecionarEstado = null;
	private List<Cidade> selecionarCidade;
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
		this.selecionarEstado = null;
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Parte Contraria Cadastrada!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public String excluir() {
		ParteContrariaFacade parteRN = new ParteContrariaFacade();
		parteRN.excluir(parte);
		this.parte = new ParteContraria();
		this.selecionarEstado = null;
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Parte Contraria Excluida!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public void clean() {
		this.parte = new ParteContraria();
		this.selecionarEstado = null;
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
		if(this.parte.getEndereco().getCidade().getEstado().getCodigo() != 0) {
			CidadeFacade fornRN = new CidadeFacade();
			int n = this.parte.getEndereco().getCidade().getEstado().getCodigo();
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
		int n = this.parte.getEndereco().getCidade().getEstado().getCodigo();
		try {	    		
			this.selecionarCidade = estadoRN.listar(n);
		} catch (Throwable e) {
			e.printStackTrace();
		}      
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