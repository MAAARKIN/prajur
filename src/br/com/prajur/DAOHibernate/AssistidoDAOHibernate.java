package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.prajur.DAO.AssistidoDAO;
import br.com.prajur.modelo.Assistido;

public class AssistidoDAOHibernate implements AssistidoDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Assistido assistido) {
		this.session.save(assistido);		
	}

	@Override
	public void atualizar(Assistido assistido) {
		this.session.update(assistido);		
	}

	@Override
	public void excluir(Assistido assistido) {
		this.session.delete(assistido);		
	}

	@Override
	public Assistido carregar(int codigo) {
		return (Assistido) this.session.get(Assistido.class, codigo);
	}

	@Override
	public List<Assistido> listar() {
		return this.session.createCriteria(Assistido.class).list();
	}
}
