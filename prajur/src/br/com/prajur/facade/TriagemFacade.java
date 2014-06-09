package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.TriagemDAO;
import br.com.prajur.modelo.Triagem;
import br.com.prajur.util.DAOFactory;

public class TriagemFacade {

	private TriagemDAO triDAO;
	
	public TriagemFacade() {
		this.triDAO = DAOFactory.criarTriagemDAO();
	}
	
	public Triagem carregar(int codigo) {
		return this.triDAO.carregar(codigo);
	}
	
	public Triagem carregarTriagem(int codigo) {
		return this.triDAO.carregaTriagem(codigo);
	}
	
	public void salvar(Triagem triagem) {
		Integer codigo = triagem.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.triDAO.salvar(triagem);
		} else {
			this.triDAO.atualizar(triagem);
		}
	}
	
	public void atualizar(Triagem triagem) {
		this.triDAO.atualizar(triagem);
	}
	
	public void excluir(Triagem triagem) {
		this.triDAO.excluir(triagem);
	}
	
	public List<Triagem> listar() {
		return this.triDAO.listar();
	}
	
	public List<String> listarPoliticas(int codigo) {
		return this.triDAO.listarPoliticas(codigo);
	}
	
}
