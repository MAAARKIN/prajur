package br.com.prajur.DAOHibernate;

import java.sql.BatchUpdateException;
import java.util.List;

import org.hibernate.Session;

import br.com.prajur.DAO.TipoMovimentoDAO;
import br.com.prajur.modelo.TipoMovimento;

public class TipoMovimentoDAOHibernate implements TipoMovimentoDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(TipoMovimento tipoMovimento) {
		this.session.save(tipoMovimento);		
	}

	@Override
	public void atualizar(TipoMovimento tipoMovimento) {
		this.session.update(tipoMovimento);		
	}

	@Override
	public void excluir(TipoMovimento tipoMovimento) {
		this.session.delete(tipoMovimento);		
	}

	@Override
	public TipoMovimento carregar(int codigo) {
		return (TipoMovimento) this.session.get(TipoMovimento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoMovimento> listar() {
		return this.session.createCriteria(TipoMovimento.class).list();
	}

}
