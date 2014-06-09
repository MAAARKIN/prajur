package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.QualiAssistidoDAO;
import br.com.prajur.modelo.QualiAssistido;
import br.com.prajur.util.DAOFactory;

public class QualiAssistidoFacade {

	private QualiAssistidoDAO qualiDAO;
	
	public QualiAssistidoFacade() {
		this.qualiDAO = DAOFactory.criarQualiDAO();
	}
	
	public QualiAssistido carregar(int codigo) {
		return this.qualiDAO.carregar(codigo);
	}
	
	public void salvar(QualiAssistido quali) {
		Integer codigo = quali.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.qualiDAO.salvar(quali);
		} else {
			this.qualiDAO.atualizar(quali);
		}
	}
	
	public void atualizar(QualiAssistido quali) {
		this.qualiDAO.atualizar(quali);
	}
	
	public void excluir(QualiAssistido quali) {
		this.qualiDAO.excluir(quali);
	}
	
	public List<QualiAssistido> listar(int codigo) {
		return this.qualiDAO.listar(codigo);
	}
	
}
