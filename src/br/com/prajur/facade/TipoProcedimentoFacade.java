package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.TipoProcedimentoDAO;
import br.com.prajur.modelo.TipoProcedimento;
import br.com.prajur.util.DAOFactory;

public class TipoProcedimentoFacade {
	
	private TipoProcedimentoDAO tipoProcedimentoDAO;

	public TipoProcedimentoFacade() {
		this.tipoProcedimentoDAO = DAOFactory.criarTipoProcedimentoDAO();
	}
	
	public TipoProcedimento carregar(int codigo) {
		return this.tipoProcedimentoDAO.carregar(codigo);
	}
	
	public void salvar(TipoProcedimento tipoAcao) {
		Integer codigo = tipoAcao.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.tipoProcedimentoDAO.salvar(tipoAcao);
		} else {
			this.tipoProcedimentoDAO.atualizar(tipoAcao);
		}
	}
	
	public void atualizar(TipoProcedimento tipoAcao) {
		this.tipoProcedimentoDAO.atualizar(tipoAcao);
	}
	
	public void excluir(TipoProcedimento tipoAcao) {
		this.tipoProcedimentoDAO.excluir(tipoAcao);
	}
	
	public List<TipoProcedimento> listar() {
		return this.tipoProcedimentoDAO.listar();
	}

}
