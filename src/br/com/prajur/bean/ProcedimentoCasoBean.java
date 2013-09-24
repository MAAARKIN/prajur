package br.com.prajur.bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prajur.facade.ProcedimentoFacade;
import br.com.prajur.facade.TipoProcedimentoFacade;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Procedimento;
import br.com.prajur.modelo.TipoProcedimento;

@ManagedBean(name="procedimentoCasoBean")
@ViewScoped
public class ProcedimentoCasoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8229467435099166440L;
	private Procedimento proc;
	private Caso caso;
	private List<Procedimento> listar;
	private Date data = new Date(System.currentTimeMillis());
	private SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
	
	public ProcedimentoCasoBean() {
		this.proc = new Procedimento();
		this.caso = new Caso();
	}
	
	public String salvar() {
		this.proc.setDataModificacao(formatarDate.format(data));
		this.proc.setCodProcessoProcedimento(this.caso);
		ProcedimentoFacade procRN = new ProcedimentoFacade();
		procRN.salvar(this.proc);
		this.proc = new Procedimento();
		return null;
	}
	
	public void clean() {
		this.proc = new Procedimento();
		this.caso = new Caso();
	}

	public Procedimento getProc() {
		return proc;
	}

	public void setProc(Procedimento proc) {
		this.proc = proc;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public List<Procedimento> getListar() {
		ProcedimentoFacade procRN = new ProcedimentoFacade();
		this.listar = procRN.listar(this.caso.getCodigo());
		return this.listar;
	}
	
	public List<TipoProcedimento> completeProc(String query) {
		TipoProcedimentoFacade tipoProcRN = new TipoProcedimentoFacade();
		List<TipoProcedimento> lista = tipoProcRN.listar();
		List<TipoProcedimento> sugestao = new ArrayList<TipoProcedimento>();
		for(TipoProcedimento p : lista) {
			if(p.getDescricao().startsWith(query)) {
				sugestao.add(p);
			}
		}
		return sugestao;
	}
	
}
