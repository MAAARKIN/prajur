package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Session;

import br.com.prajur.DAO.AdvogadoDAO;
import br.com.prajur.modelo.Advogado;

public class AdvogadoDAOHibernate implements AdvogadoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Advogado advogado) {
		this.session.save(advogado);		
	}

	@Override
	public void atualizar(Advogado advogado) {
		this.session.update(advogado);		
	}

	@Override
	public void excluir(Advogado advogado) {
		this.session.delete(advogado);		
	}

	@Override
	public Advogado carregar(int codigo) {
		return (Advogado) this.session.get(Advogado.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Advogado> listar() {
		return this.session.createCriteria(Advogado.class).list();
	}
}
