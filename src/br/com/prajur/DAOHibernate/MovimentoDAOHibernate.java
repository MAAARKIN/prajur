package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.MovimentoDAO;
import br.com.prajur.modelo.Movimento;
import br.com.prajur.modelo.Procedimento;

public class MovimentoDAOHibernate implements MovimentoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Movimento movimento) {
		this.session.save(movimento);
	}

	@Override
	public void atualizar(Movimento movimento) {
		this.session.update(movimento);		
	}

	@Override
	public void excluir(Movimento movimento) {
		this.session.delete(movimento);		
	}

	@Override
	public Movimento carregar(int codigo) {
		return (Movimento) this.session.get(Movimento.class, codigo);		
	}

	@Override
	public List<Movimento> listar(int codigo) {
		String hql = "select m from Movimento m where m.codProcessoMovimento = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return consulta.list();
	}
}
