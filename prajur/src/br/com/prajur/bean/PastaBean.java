package br.com.prajur.bean;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import br.com.prajur.facade.PastaFacade;
import br.com.prajur.modelo.Assistido;
import br.com.prajur.modelo.Documento;
import br.com.prajur.modelo.ParteContraria;
import br.com.prajur.modelo.Pasta;
import br.com.prajur.modelo.QualiAssistido;
import br.com.prajur.modelo.Triagem;

@ManagedBean(name="pastaBean")
@ViewScoped
public class PastaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4454668220057803951L;
	
	private Pasta pasta;
	private Assistido assistido;
	private Triagem triagem;
	private List<QualiAssistido> quali;
	private QualiAssistido qualiAssistido;
	private List<ParteContraria> contrarios;
	private ParteContraria parteContraria;
	private List<Documento> documentos;
	private Documento documento;
	private List<Pasta> listar;
	private List<String> politicas;
	private boolean triagemNext = false;
	
	public PastaBean() {
		this.quali = new ArrayList<QualiAssistido>();
		this.contrarios = new ArrayList<ParteContraria>();
		this.documentos = new ArrayList<Documento>();
		this.politicas = new ArrayList<String>();
		this.assistido = new Assistido();
		this.pasta = new Pasta();
		this.triagem = new Triagem();
		this.documento = new Documento();
		this.qualiAssistido = new QualiAssistido();
		this.parteContraria = new ParteContraria();
	}
	
	public void clean() {
		this.pasta = new Pasta();
		this.triagem = new Triagem();
		this.documento = new Documento();
		this.qualiAssistido = new QualiAssistido();
		this.parteContraria = new ParteContraria();
		this.triagemNext = false;
		this.contrarios = new ArrayList<ParteContraria>();
		this.documentos = new ArrayList<Documento>();
		this.quali = new ArrayList<QualiAssistido>();
	}
	
	public String confirmTriagem() {
		this.pasta.setDocumentos(documentos);
		this.triagem.setPoliticas(politicas);
		this.triagem.setData(new Date(System.currentTimeMillis()));
		this.triagemNext = true;
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Triagem Confirmada!");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public String salvar() {
		if(triagemNext == false) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Não Concluído","Triagem não foi Confirmada!");
			context.addMessage(null, facesMessage);
			return null;
		}
		
/*
		if(this.quali.size() == 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Você não cadastrou Qualificados");
			context.addMessage(null, facesMessage);
			return null;
		} 
		
		if(this.contrarios.size() == 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Você nao cadastrou Parte Contrária");
			context.addMessage(null, facesMessage);
			return null;
		} 
*/		
		this.triagem.setCodPasta(this.pasta);
		this.pasta.setDocumentos(documentos);
		this.pasta.setAssistido(this.assistido);
		this.pasta.setPartesContrarias(this.contrarios);
		this.pasta.setQualiAssistidos(this.quali);
		this.pasta.setTriagem(this.triagem);
		this.pasta.setContemCaso(false);
		PastaFacade pastaRN = new PastaFacade();
		pastaRN.salvar(pasta);
		this.pasta = new Pasta();
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Pasta Cadastrada!");
		context.addMessage(null, facesMessage);
		RequestContext contexto = RequestContext.getCurrentInstance();
		contexto.execute("criarPastaDlg.hide()");
		return null;		
	}
	
	public String abrirCaso() {
		if(this.pasta.getQualiAssistidos().size() == 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Você não cadastrou Qualificados");
			context.addMessage(null, facesMessage);
			this.pasta = new Pasta();
			return null;
		} 
		
		if(this.pasta.getPartesContrarias().size() == 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			FacesMessage facesMessage = new FacesMessage("Você nao cadastrou Parte Contrária");
			context.addMessage(null, facesMessage);
			this.pasta = new Pasta();
			return null;
		}
		this.pasta = new Pasta();
		RequestContext contexto = RequestContext.getCurrentInstance();
		contexto.execute("addCasoDlg.show()");
		return null;	
	}
	
	public String addDocumento() {
		if(contemDoc() == false) {
			this.documento.setCodPasta(this.pasta);
			this.documentos.add(this.documento);
			this.documento = new Documento();	
			return null;
		}
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage("Documento já existe");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public boolean contemDoc() {
		for (Documento d : documentos) {
			if (this.documento.getDescricao().equals(d.getDescricao())) {
				return true;
			}
		}
		return false;
	}
	
	public void addQualiAssistido() {
		this.qualiAssistido.setPastaAssistido(this.pasta);
		this.quali.add(this.qualiAssistido);
		this.qualiAssistido = new QualiAssistido();
	}
	
	public void addParteContraria() {
		this.parteContraria.setPastaContraria(this.pasta);
		this.contrarios.add(this.parteContraria);
		this.parteContraria = new ParteContraria();
	}
	
	public Pasta getPasta() {
		return pasta;
	}

	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}

	public Assistido getAssistido() {
		return assistido;
	}

	public void setAssistido(Assistido assistido) {
		this.assistido = assistido;
	}

	public Triagem getTriagem() {
		return triagem;
	}

	public void setTriagem(Triagem triagem) {
		this.triagem = triagem;
	}

	public List<QualiAssistido> getQuali() {
		return quali;
	}

	public void setQuali(List<QualiAssistido> quali) {
		this.quali = quali;
	}

	public List<ParteContraria> getContrarios() {
		return contrarios;
	}

	public void setContrarios(List<ParteContraria> contrarios) {
		this.contrarios = contrarios;
	}

	public List<Pasta> getListar() {
		PastaFacade pastaRN = new PastaFacade();
		return this.listar = pastaRN.listar(this.assistido.getCodigo());			
	}

	public void setListar(List<Pasta> listar) {
		this.listar = listar;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public void setDocumentos(List<Documento> documentos) {
		this.documentos = documentos;
	}

	public QualiAssistido getQualiAssistido() {
		return qualiAssistido;
	}

	public void setQualiAssistido(QualiAssistido qualiAssistido) {
		this.qualiAssistido = qualiAssistido;
	}

	public ParteContraria getParteContraria() {
		return parteContraria;
	}

	public void setParteContraria(ParteContraria parteContraria) {
		this.parteContraria = parteContraria;
	}

	public Documento getDocumento() {
		return documento;
	}

	public void setDocumento(Documento documento) {
		this.documento = documento;
	}

	public List<String> getPoliticas() {
		return politicas;
	}

	public void setPoliticas(List<String> politicas) {
		this.politicas = politicas;
	}

	public boolean isTriagemNext() {
		return triagemNext;
	}

	public void setTriagemNext(boolean triagemNext) {
		this.triagemNext = triagemNext;
	}
	
}
