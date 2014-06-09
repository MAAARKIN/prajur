package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.QualiAssistidoDAO;
import br.com.prajur.modelo.QualiAssistido;

public class QualiAssistidoDAOHibernate implements QualiAssistidoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(QualiAssistido qualiAssistido) {
		this.session.save(qualiAssistido);
	}

	@Override
	public void atualizar(QualiAssistido qualiAssistido) {
		this.session.update(qualiAssistido);
	}

	@Override
	public void excluir(QualiAssistido qualiAssistido) {
		this.session.delete(qualiAssistido);
	}

	@Override
	public QualiAssistido carregar(int codigo) {
		return (QualiAssistido) this.session.get(QualiAssistido.class, codigo);
	}

	@Override
	public List<QualiAssistido> listar(int codigo) {
		String hql = "select q FROM QualiAssistido q WHERE q.pastaAssistido = :parametro";
		Query consulta = session.createQuery(hql);
		consulta.setInteger("parametro", codigo);
		return (List<QualiAssistido>) consulta.list();
	}

}
