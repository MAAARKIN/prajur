package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.TriagemDAO;
import br.com.prajur.modelo.Triagem;

public class TriagemDAOHibernate implements TriagemDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Triagem triagem) {
		this.session.save(triagem);
	}

	@Override
	public void atualizar(Triagem triagem) {
		this.session.update(triagem);
	}

	@Override
	public void excluir(Triagem triagem) {
		this.session.delete(triagem);
	}

	@Override
	public Triagem carregar(int codigo) {
		return (Triagem) this.session.get(Triagem.class, codigo);
	}

	@Override
	public List<Triagem> listar() {
		return this.session.createCriteria(Triagem.class).list();
	}

	@Override
	public Triagem carregaTriagem(int codigo) {
		String hql = "select t FROM Triagem t WHERE t.codPasta = :parametro";
		Query consulta = session.createQuery(hql);
		consulta.setInteger("parametro", codigo);
		return (Triagem) consulta.uniqueResult();
	}

	@Override
	public List<String> listarPoliticas(int codigo) {
		String hql = "select descricao FROM triagem_politicas WHERE triagem_politicas.codigo = :parametro";
		Query consulta = session.createSQLQuery(hql);
		consulta.setInteger("parametro", codigo);
		return (List<String>) consulta.list();
	}

}
