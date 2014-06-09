package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.ParteContrariaDAO;
import br.com.prajur.modelo.ParteContraria;
import br.com.prajur.util.DAOFactory;

public class ParteContrariaFacade {

	private ParteContrariaDAO parteDAO;
	
	public ParteContrariaFacade() {
		this.parteDAO = DAOFactory.criarParteDAO();
	}
	
	public ParteContraria carregar(int codigo) {
		return this.parteDAO.carregar(codigo);
	}
	
	public void salvar(ParteContraria parte) {
		Integer codigo = parte.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.parteDAO.salvar(parte);
		} else {
			this.parteDAO.atualizar(parte);
		}
	}
	
	public void atualizar(ParteContraria parte) {
		this.parteDAO.atualizar(parte);
	}
	
	public void excluir(ParteContraria parte) {
		this.parteDAO.excluir(parte);
	}
	
	public List<ParteContraria> listar(int codigo) {
		return this.parteDAO.listar(codigo);
	}
	
}