package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.ProcedimentoDAO;
import br.com.prajur.modelo.Procedimento;

public class ProcedimentoDAOHibernate implements ProcedimentoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Procedimento procedimento) {
		this.session.save(procedimento);
	}

	@Override
	public void atualizar(Procedimento procedimento) {
		this.session.update(procedimento);		
	}

	@Override
	public void excluir(Procedimento procedimento) {
		this.session.delete(procedimento);		
	}

	@Override
	public Procedimento carregar(int codigo) {
		return (Procedimento) this.session.get(Procedimento.class, codigo);		
	}

	@Override
	public List<Procedimento> listar(int codigo) {
		String hql = "select p from Procedimento p where p.codProcessoProcedimento = :codigo ORDER BY p.codigo DESC";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return consulta.list();
	}
}
