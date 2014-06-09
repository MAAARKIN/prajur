package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.EstadoDAO;
import br.com.prajur.modelo.Estado;
import br.com.prajur.util.DAOFactory;

public class EstadoFacade {
	
private EstadoDAO estadoDAO;
	
	public EstadoFacade() {
		this.estadoDAO = DAOFactory.criarEstadoDAO();
	}
	
	public Estado carregar(int codigo) {
		return this.estadoDAO.carregar(codigo);
	}
	
	public void salvar(Estado estado) {
		Integer codigo = estado.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.estadoDAO.salvar(estado);
		} else {
			this.estadoDAO.atualizar(estado);
		}
	}
	
	public void atualizar(Estado estado) {
		this.estadoDAO.atualizar(estado);
	}
	
	public void excluir(Estado estado) {
		this.estadoDAO.excluir(estado);
	}
	
	public List<Estado> listar() {
		return this.estadoDAO.listar();
	}
}