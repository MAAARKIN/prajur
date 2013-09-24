package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.PastaDAO;
import br.com.prajur.modelo.Pasta;

public class PastaDAOHibernate implements PastaDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Pasta pasta) {
		this.session.save(pasta);		
	}

	@Override
	public void atualizar(Pasta pasta) {
		this.session.update(pasta);		
	}

	@Override
	public void excluir(Pasta pasta) {
		this.session.delete(pasta);		
	}

	@Override
	public Pasta carregar(int codigo) {
		return (Pasta) this.session.get(Pasta.class, codigo);
	}

	@Override
	public List<Pasta> listar(int codigo) {
		String hql = "select p FROM Pasta p WHERE p.assistido = :parametro";
		Query consulta = session.createQuery(hql);
		consulta.setInteger("parametro", codigo);
		return (List<Pasta>) consulta.list();
	}
}
