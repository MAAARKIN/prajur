package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.AssistidoDAO;
import br.com.prajur.modelo.Assistido;
import br.com.prajur.util.DAOFactory;

public class AssistidoFacade {

	private AssistidoDAO assistidoDAO;

	public AssistidoFacade() {
		this.assistidoDAO = DAOFactory.criarAssitidoDAO();
	}
	
	public Assistido carregar(int codigo) {
		return this.assistidoDAO.carregar(codigo);
	}
	
	public void salvar(Assistido assistido) {
		Integer codigo = assistido.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.assistidoDAO.salvar(assistido);
		} else {
			this.assistidoDAO.atualizar(assistido);
		}
	}
	
	public void atualizar(Assistido assistido) {
		this.assistidoDAO.atualizar(assistido);
	}
	
	public void excluir(Assistido assistido) {
		this.assistidoDAO.excluir(assistido);
	}
	
	public List<Assistido> listar() {
		return this.assistidoDAO.listar();
	}
}
