package br.com.prajur.facade;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import br.com.prajur.DAO.PastaDAO;
import br.com.prajur.modelo.Pasta;
import br.com.prajur.util.DAOFactory;

public class PastaFacade {
	
	private PastaDAO pastaDAO;
	Date data = new Date(System.currentTimeMillis());
	SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
	
	public PastaFacade() {
		this.pastaDAO = DAOFactory.criarPastaDAO();
	}

	public Pasta carregar(int codigo) {
		return this.pastaDAO.carregar(codigo);
	}
	
	public void salvar(Pasta pasta) {
		Integer codigo = pasta.getCodigo();
		if(codigo == null|| codigo == 0) {
			pasta.setData(formatarDate.format(data));
			this.pastaDAO.salvar(pasta);
		} else {
			this.pastaDAO.atualizar(pasta);
		}
	}
	
	public void atualizar(Pasta pasta) {
		this.pastaDAO.atualizar(pasta);
	}
	
	public void excluir(Pasta pasta) {
		this.pastaDAO.excluir(pasta);
	}
	
	public List<Pasta> listar(int codigo) {
		return this.pastaDAO.listar(codigo);
	}
}
