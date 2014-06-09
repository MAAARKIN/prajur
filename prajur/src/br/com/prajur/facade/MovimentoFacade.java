package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.MovimentoDAO;
import br.com.prajur.modelo.Movimento;
import br.com.prajur.util.DAOFactory;

public class MovimentoFacade {

private MovimentoDAO movDAO;
	
	public MovimentoFacade() {
		this.movDAO = DAOFactory.criarMovimentoDAO();
	}
	
	public Movimento carregar(int codigo) {
		return this.movDAO.carregar(codigo);
	}
	
	public void salvar(Movimento movimento) {
		Integer codigo = movimento.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.movDAO.salvar(movimento);
		} else {
			this.movDAO.atualizar(movimento);
		}
	}
	
	public void atualizar(Movimento movimento) {
		this.movDAO.atualizar(movimento);
	}
	
	public void excluir(Movimento movimento) {
		this.movDAO.excluir(movimento);
	}
	
	public List<Movimento> listar(int codigo) {
		return this.movDAO.listar(codigo);
	}
}
