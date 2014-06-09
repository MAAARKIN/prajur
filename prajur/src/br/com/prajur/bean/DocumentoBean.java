package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.prajur.facade.DocumentoFacade;
import br.com.prajur.modelo.Documento;
import br.com.prajur.modelo.Pasta;

@ManagedBean(name="documentoBean")
@ViewScoped
public class DocumentoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -700329274068565938L;
	private Pasta pasta;
	private Documento documento;
	private List<Documento> listar;
	
	public DocumentoBean() {
		this.pasta = new Pasta();
		this.documento = new Documento();
	}
	
	public String salvar() {
		if(contemDoc() == false) {
			this.documento.setCodPasta(pasta);
			DocumentoFacade docRN = new DocumentoFacade();
			docRN.salvar(documento);
			this.documento = new Documento();
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Documento Cadastrado!");
			context.addMessage(null, facesMessage);
			return null;
		}
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Documento j� existe");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public String excluir() {
		DocumentoFacade docRN = new DocumentoFacade();
		docRN.excluir(this.documento);
		this.documento = new Documento();
		return null;
	}

	public boolean contemDoc() {
		for (Documento d : listar) {
			if (this.documento.getDescricao().equals(d.getDescricao())) {
				return true;
			}
		}
		return false;
	}
	
	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}
	
	public List<Documento> getListar() {
		DocumentoFacade docRN = new DocumentoFacade();
		return this.listar = docRN.listar(this.pasta.getCodigo());
	}
	
	
}
