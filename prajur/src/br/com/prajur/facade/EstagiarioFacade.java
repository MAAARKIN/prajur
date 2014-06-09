package br.com.prajur.facade;

import java.sql.Date;
import java.util.List;

import br.com.prajur.DAO.EstagiarioDAO;
import br.com.prajur.modelo.Estagiario;
import br.com.prajur.util.DAOFactory;

public class EstagiarioFacade {
	
private EstagiarioDAO estagiarioDAO;
	
	public EstagiarioFacade() {
		this.estagiarioDAO = DAOFactory.criarEstagiarioDAO();
	}
	
	public Estagiario carregar(int codigo) {
		return this.estagiarioDAO.carregar(codigo);
	}
	
	public void salvar(Estagiario estagiario) {
		Integer codigo = estagiario.getCodigo();
		if(codigo == null|| codigo == 0) {
			estagiario.setDataModificacao(new Date(System.currentTimeMillis()));
			this.estagiarioDAO.salvar(estagiario);
		} else {
			this.estagiarioDAO.atualizar(estagiario);
		}
	}
	
	public void atualizar(Estagiario estagiario) {
		this.estagiarioDAO.atualizar(estagiario);
	}
	
	public void excluir(Estagiario estagiario) {
		this.estagiarioDAO.excluir(estagiario);
	}
	
	public List<Estagiario> listar() {
		return this.estagiarioDAO.listar();
	}

}
