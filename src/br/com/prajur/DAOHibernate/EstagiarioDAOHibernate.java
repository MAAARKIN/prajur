package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.prajur.DAO.EstagiarioDAO;
import br.com.prajur.modelo.Estagiario;

public class EstagiarioDAOHibernate implements EstagiarioDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Estagiario estagiario) {
		this.session.save(estagiario);		
	}

	@Override
	public void atualizar(Estagiario estagiario) {
		this.session.update(estagiario);		
	}

	@Override
	public void excluir(Estagiario estagiario) {
		this.session.delete(estagiario);		
	}

	@Override
	public Estagiario carregar(int codigo) {
		return (Estagiario) this.session.get(Estagiario.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estagiario> listar() {
		return this.session.createCriteria(Estagiario.class).list();
	}
}
