package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.prajur.DAO.TipoProcedimentoDAO;
import br.com.prajur.modelo.TipoProcedimento;

public class TipoProcedimentoDAOHibernate implements TipoProcedimentoDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(TipoProcedimento tipoAcao) {
		this.session.save(tipoAcao);		
	}

	@Override
	public void atualizar(TipoProcedimento tipoAcao) {
		this.session.update(tipoAcao);		
	}

	@Override
	public void excluir(TipoProcedimento tipoAcao) {
		this.session.delete(tipoAcao);		
	}

	@Override
	public TipoProcedimento carregar(int codigo) {
		return (TipoProcedimento) this.session.get(TipoProcedimento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoProcedimento> listar() {
		return this.session.createCriteria(TipoProcedimento.class).list();
	}
	
}
