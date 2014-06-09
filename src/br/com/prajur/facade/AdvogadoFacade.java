package br.com.prajur.facade;

import java.sql.Date;
import java.util.List;

import br.com.prajur.DAO.AdvogadoDAO;
import br.com.prajur.modelo.Advogado;
import br.com.prajur.util.DAOFactory;

public class AdvogadoFacade {
	
	private AdvogadoDAO advogadoDAO;

	public AdvogadoFacade() {
		this.advogadoDAO = DAOFactory.criarAdvogadoDAO();
	}
	
	public Advogado carregar(int codigo) {
		return this.advogadoDAO.carregar(codigo);
	}
	
	public void salvar(Advogado advogado) {
		Integer codigo = advogado.getCodigo();
		if(codigo == null|| codigo == 0) {
			advogado.setDataModificacao(new Date(System.currentTimeMillis()));
			this.advogadoDAO.salvar(advogado);
		} else {
			this.advogadoDAO.atualizar(advogado);
		}
	}
	
	public void atualizar(Advogado advogado) {
		this.advogadoDAO.atualizar(advogado);
	}
	
	public void excluir(Advogado advogado) {
		this.advogadoDAO.excluir(advogado);
	}
	
	public List<Advogado> listar() {
		return this.advogadoDAO.listar();
	}
}
