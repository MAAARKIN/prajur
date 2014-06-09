package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.DocumentoDAO;
import br.com.prajur.modelo.Documento;
import br.com.prajur.util.DAOFactory;

public class DocumentoFacade {

	private DocumentoDAO docDAO;
	
	public DocumentoFacade() {
		this.docDAO = DAOFactory.criarDocumentoDAO();
	}
	
	public Documento carregar(int codigo) {
		return this.docDAO.carregar(codigo);
	}
	
	public void salvar(Documento doc) {
		Integer codigo = doc.getCodigo();
		if(codigo == null|| codigo == 0) {
			this.docDAO.salvar(doc);
		} else {
			this.docDAO.atualizar(doc);
		}
	}
	
	public void atualizar(Documento doc) {
		this.docDAO.atualizar(doc);
	}
	
	public void excluir(Documento doc) {
		this.docDAO.excluir(doc);
	}
	
	public List<Documento> listar(int codigo) {
		return this.docDAO.listar(codigo);
	}
}
