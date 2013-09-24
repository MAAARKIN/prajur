package br.com.prajur.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prajur.facade.ProfessorFacade;
import br.com.prajur.modelo.Professor;

@ManagedBean(name="professorBean")
@ViewScoped
public class ProfessorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3748169029830294423L;
	private Professor professor;
	private List<Professor> listar;

	public ProfessorBean() {
		this.professor = new Professor();
	}

	public String salvar() {
		ProfessorFacade profRN = new ProfessorFacade();
		profRN.salvar(this.professor);
		this.professor = new Professor();
		return null;
	}
	
	public String excluir() {
		ProfessorFacade profRN = new ProfessorFacade();
		profRN.excluir(this.professor);
		this.professor = new Professor();
		return null;
	}

	public void clean() {
		this.professor = new Professor();
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Professor> getListar() {
		ProfessorFacade profRN = new ProfessorFacade();
		return this.listar = profRN.listar();
	}

}
