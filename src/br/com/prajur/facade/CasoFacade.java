package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.CasoDAO;
import br.com.prajur.modelo.Advogado;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Estagiario;
import br.com.prajur.modelo.Professor;
import br.com.prajur.util.DAOFactory;

public class CasoFacade {

	private CasoDAO casoDAO;
	
	public CasoFacade() {
		this.casoDAO = DAOFactory.criarCasoDAO();
	}
	
	public Caso carregar(int codigo) {
		return this.casoDAO.carregar(codigo);
	}
	
	public void salvar(Caso caso) {
		Integer codigo = caso.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.casoDAO.salvar(caso);
		} else {
			this.casoDAO.atualizar(caso);
		}
	}
	
	public void atualizar(Caso caso) {
		this.casoDAO.atualizar(caso);
	}
	
	public void excluir(Caso caso) {
		this.casoDAO.excluir(caso);
	}
	
	public List<Caso> listar() {
		return this.casoDAO.listar();
	}
	
	public List<Professor> professoresComCaso(int codigo) {
		return this.casoDAO.casoProfessores(codigo);
	}
	
	public List<Advogado> advogadosComCaso(int codigo) {
		return this.casoDAO.casoAdvogados(codigo);
	}
	
	public List<Estagiario> estagiariosComCaso(int codigo) {
		return this.casoDAO.casoEstagiarios(codigo);
	}
	
}
