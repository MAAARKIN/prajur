package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.ProfessorDAO;
import br.com.prajur.modelo.Professor;
import br.com.prajur.util.DAOFactory;

public class ProfessorFacade {

private ProfessorDAO profDAO;
	
	public ProfessorFacade() {
		this.profDAO = DAOFactory.criarProfessorDAO();
	}
	
	public Professor carregar(int codigo) {
		return this.profDAO.carregar(codigo);
	}
	
	public void salvar(Professor professor) {
		Integer codigo = professor.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.profDAO.salvar(professor);
		} else {
			this.profDAO.atualizar(professor);
		}
	}
	
	public void atualizar(Professor professor) {
		this.profDAO.atualizar(professor);
	}
	
	public void excluir(Professor professor) {
		this.profDAO.excluir(professor);
	}
	
	public List<Professor> listar() {
		return this.profDAO.listar();
	}
}
