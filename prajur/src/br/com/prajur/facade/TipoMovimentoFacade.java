package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.TipoMovimentoDAO;
import br.com.prajur.modelo.TipoMovimento;
import br.com.prajur.util.DAOFactory;

public class TipoMovimentoFacade {
	private TipoMovimentoDAO tipoMovDAO;

	public TipoMovimentoFacade() {
		this.tipoMovDAO = DAOFactory.criarTipoMovimentoDAO();
	}
	
	public TipoMovimento carregar(int codigo) {
		return this.tipoMovDAO.carregar(codigo);
	}
	
	public void salvar(TipoMovimento tipoMov) {
		Integer codigo = tipoMov.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.tipoMovDAO.salvar(tipoMov);
		} else {
			this.tipoMovDAO.atualizar(tipoMov);
		}
	}
	
	public void atualizar(TipoMovimento tipoMov) {
		this.tipoMovDAO.atualizar(tipoMov);
	}
	
	public void excluir(TipoMovimento tipoMov) {
		this.tipoMovDAO.excluir(tipoMov);
	}
	
	public List<TipoMovimento> listar() {
		return this.tipoMovDAO.listar();
	}
	
}
