package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.ProcedimentoDAO;
import br.com.prajur.modelo.Procedimento;
import br.com.prajur.util.DAOFactory;

public class ProcedimentoFacade {
	
	private ProcedimentoDAO procDAO;
	
	public ProcedimentoFacade() {
		this.procDAO = DAOFactory.criarProcedimentoDAO();
	}
	
	public Procedimento carregar(int codigo) {
		return this.procDAO.carregar(codigo);
	}
	
	public void salvar(Procedimento procedimento) {
		Integer codigo = procedimento.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.procDAO.salvar(procedimento);
		} else {
			this.procDAO.atualizar(procedimento);
		}
	}
	
	public void atualizar(Procedimento procedimento) {
		this.procDAO.atualizar(procedimento);
	}
	
	public void excluir(Procedimento procedimento) {
		this.procDAO.excluir(procedimento);
	}
	
	public List<Procedimento> listar(int codigo) {
		return this.procDAO.listar(codigo);
	}
}
