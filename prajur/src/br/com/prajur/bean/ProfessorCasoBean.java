package br.com.prajur.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prajur.facade.CasoFacade;
import br.com.prajur.facade.ProfessorFacade;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Professor;

@ManagedBean(name="professorCasoBean")
@ViewScoped
public class ProfessorCasoBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2547911329650791392L;
	private Caso caso;
	private List<Professor> listar;
	private Professor professor;
	
	public ProfessorCasoBean() {
		this.caso = new Caso();
		this.professor = new Professor();
	}
	
	public String salvar() {
		this.listar.add(professor);
		this.caso.setProfessor(listar);
		CasoFacade casoRN = new CasoFacade();
		casoRN.salvar(caso);
		this.professor = new Professor();
		return null;
	}
	
	public String excluir() {
		this.listar.remove(professor);
		this.caso.setProfessor(listar);
//		this.caso.getProfessor().clear();
//		this.caso.getProfessor().addAll(listar);
		CasoFacade casoRN = new CasoFacade();
		casoRN.salvar(caso);
		this.professor = new Professor();
		return null;
	}
	
	public void clean() {
		this.professor = new Professor();
		this.caso = new Caso();
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public List<Professor> getListar() {
		CasoFacade cf = new CasoFacade();
		this.listar = cf.professoresComCaso(this.caso.getCodigo());
//		Collections.reverse(this.listar);
		return listar;
	}

	public void setListar(List<Professor> listaProfessores) {
		this.listar = listaProfessores;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

	
}
