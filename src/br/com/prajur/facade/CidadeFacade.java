package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.CidadeDAO;
import br.com.prajur.modelo.Cidade;
import br.com.prajur.util.DAOFactory;

public class CidadeFacade {
	
private CidadeDAO cidadeDAO;
	
	public CidadeFacade() {
		this.cidadeDAO = DAOFactory.criarCidadeDAO();
	}
	
	public Cidade carregar(int codigo) {
		return this.cidadeDAO.carregar(codigo);
	}
	
	public void salvar(Cidade cidade) {
		Integer codigo = cidade.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.cidadeDAO.salvar(cidade);
		} else {
			this.cidadeDAO.atualizar(cidade);
		}
	}
	
	public void atualizar(Cidade cidade) {
		this.cidadeDAO.atualizar(cidade);
	}
	
	public void excluir(Cidade cidade) {
		this.cidadeDAO.excluir(cidade);
	}
	
	public List<Cidade> listar(int codigo) {
		return this.cidadeDAO.listar(codigo);
	}

}