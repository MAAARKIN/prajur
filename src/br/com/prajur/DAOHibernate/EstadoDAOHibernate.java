package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.prajur.DAO.EstadoDAO;
import br.com.prajur.modelo.Estado;

public class EstadoDAOHibernate implements EstadoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Estado estado) {
		this.session.save(estado);		
	}

	@Override
	public void atualizar(Estado estado) {
		this.session.update(estado);		
	}

	@Override
	public void excluir(Estado estado) {
		this.session.delete(estado);		
	}

	@Override
	public Estado carregar(int codigo) {
		return (Estado) this.session.get(Estado.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estado> listar() {
		return this.session.createCriteria(Estado.class).list();
	}

}
