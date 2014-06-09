package br.com.prajur.bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.primefaces.component.wizard.Wizard;
import org.primefaces.context.RequestContext;

import br.com.prajur.facade.AdvogadoFacade;
import br.com.prajur.facade.CasoFacade;
import br.com.prajur.facade.EstagiarioFacade;
import br.com.prajur.facade.ProfessorFacade;
import br.com.prajur.facade.TipoMovimentoFacade;
import br.com.prajur.facade.TipoProcedimentoFacade;
import br.com.prajur.modelo.Advogado;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Estagiario;
import br.com.prajur.modelo.Movimento;
import br.com.prajur.modelo.Procedimento;
import br.com.prajur.modelo.Professor;
import br.com.prajur.modelo.TipoMovimento;
import br.com.prajur.modelo.TipoProcedimento;

@ManagedBean(name="casoBean")
@ViewScoped
public class CasoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7086503862936702623L;
	
	private Caso caso;
	private List<Caso> listar;
	private Procedimento proc;
	private List<Procedimento> procedimentos;
	private Movimento mov;
	private List<Movimento> movimentos;
	private List<Professor> professores;
	private Professor prof;
	private Estagiario estagiario;
	private List<Estagiario> estagiarios;
	private List<Estagiario> estTemp;
	private Advogado advogado;
	private List<Advogado> advogados;
	private List<Advogado> advTemp;
	private Date data = new Date(System.currentTimeMillis());
	private SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
	
	public CasoBean() {
		this.caso = new Caso();
		this.proc = new Procedimento();
		this.procedimentos = new ArrayList<Procedimento>();
		this.mov = new Movimento();
		this.movimentos = new ArrayList<Movimento>();
		this.prof = new Professor();
		this.professores = new ArrayList<Professor>();
		this.estagiario = new Estagiario();
		this.advogado = new Advogado();
		this.estTemp = new ArrayList<Estagiario>();
		this.advTemp = new ArrayList<Advogado>();
	}
	
	public String salvar() {
		this.proc.setDataModificacao(formatarDate.format(data));
		this.proc.setCodProcessoProcedimento(this.caso);
		this.procedimentos.add(this.proc);
		this.mov.setDataModificacao(formatarDate.format(data));
		this.mov.setCodigoProcesso(this.caso);
		this.movimentos.add(this.mov);
		this.professores.add(this.prof);
		this.caso.setProcedimento(procedimentos);
		this.caso.setMovimento(movimentos);
		this.caso.setEstagiario(estTemp);
		this.caso.setAdvogado(advTemp);
		this.caso.setProfessor(professores);
		//Começa a inserção.
		CasoFacade casoRN = new CasoFacade();
		this.caso.getPasta().setContemCaso(true);
		casoRN.salvar(this.caso);
		//Emite Mensagem de sucesso.
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Concluido.","Caso cadastrado com sucesso!");
		context.addMessage(null, facesMessage);
		this.caso = new Caso();
		return null;
	}
	
	public void clean() {
		this.caso = new Caso();
		this.proc = new Procedimento();
		this.mov = new Movimento();
		this.prof = new Professor();
		this.estagiario = new Estagiario();
		this.advogado = new Advogado();
		this.estTemp = new ArrayList<Estagiario>();
		this.advTemp = new ArrayList<Advogado>();
	}
	
	public String addEstagiario() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(this.estagiario == null) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Impossível","Você não selecionou nada!");
			context.addMessage(null, facesMessage);
			return null;
		}
		if(contemEst() == false) {
			this.estTemp.add(this.estagiario);	
			return null;
		}
		FacesMessage facesMessage = new FacesMessage("Impossível","Estagiário já inserido");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public String addAdvogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		if(this.advogado == null) {
			FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Impossível","Você não selecionou nada!");
			context.addMessage(null, facesMessage);
			return null;
		}
		if(contemAdv() == false) {
			this.advTemp.add(this.advogado);	
			return null;
		}
		FacesMessage facesMessage = new FacesMessage("Impossível","Advogado já inserido");
		context.addMessage(null, facesMessage);
		return null;
	}
	
	public boolean contemEst() {
		for (Estagiario est : estTemp) {
			if (est.getCpf().equals(this.estagiario.getCpf())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contemAdv() {
		for (Advogado adv : advTemp) {
			if (adv.getNome().equals(this.advogado.getNome())) {
				return true;
			}
		}
		return false;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Procedimento getProc() {
		return proc;
	}

	public void setProc(Procedimento proc) {
		this.proc = proc;
	}
	
	public List<Caso> getListar() {
		CasoFacade casoRN = new CasoFacade();
		return this.listar = casoRN.listar();
	}

	public Professor getProf() {
		return prof;
	}

	public void setProf(Professor prof) {
		this.prof = prof;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Estagiario getEstagiario() {
		return estagiario;
	}

	public void setEstagiario(Estagiario estagiario) {
		this.estagiario = estagiario;
	}

	public List<Estagiario> getEstagiarios() {
		EstagiarioFacade estRN = new EstagiarioFacade();
		return this.estagiarios = estRN.listar();
	}

	public List<Estagiario> getEstTemp() {
		return estTemp;
	}

	public void setEstTemp(List<Estagiario> estTemp) {
		this.estTemp = estTemp;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public List<Advogado> getAdvogados() {
		AdvogadoFacade advRN = new AdvogadoFacade();
		return advogados = advRN.listar();
	}

	public List<Advogado> getAdvTemp() {
		return advTemp;
	}

	public void setAdvTemp(List<Advogado> advTemp) {
		this.advTemp = advTemp;
	}

	public List<Movimento> getMovimentos() {
		return movimentos;
	}

	public void setMovimentos(List<Movimento> movimentos) {
		this.movimentos = movimentos;
	}

	public Movimento getMov() {
		return mov;
	}

	public void setMov(Movimento mov) {
		this.mov = mov;
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
	
	public List<Professor> completeProf(String query) {
		ProfessorFacade profRN = new ProfessorFacade();
		List<Professor> profs = profRN.listar();
		List<Professor> sugestao = new ArrayList<Professor>();
		for(Professor p : profs) {
			if(p.getNome().startsWith(query)) {
				sugestao.add(p);
			}
		}
		return sugestao;
	}
	
	public List<TipoMovimento> completeMov(String query) {
		TipoMovimentoFacade tipoMovRN = new TipoMovimentoFacade();
		List<TipoMovimento> lista = tipoMovRN.listar();
		List<TipoMovimento> sugestao = new ArrayList<TipoMovimento>();
		for(TipoMovimento p : lista) {
			if(p.getDescricao().startsWith(query)) {
				sugestao.add(p);
			}
		}
		return sugestao;
	}
	
}
