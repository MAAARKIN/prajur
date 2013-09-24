package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.CidadeDAO;
import br.com.prajur.modelo.Cidade;

public class CidadeDAOHibernate implements CidadeDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Cidade cidade) {
		this.session.save(cidade);
	}

	@Override
	public void atualizar(Cidade cidade) {
		this.session.update(cidade);		
	}

	@Override
	public void excluir(Cidade cidade) {
		this.session.delete(cidade);		
	}

	@Override
	public Cidade carregar(int codigo) {
		return (Cidade) this.session.get(Cidade.class, codigo);		
	}

	@Override
	public List<Cidade> listar(int codigo) {
		String hql = "select c from Cidade c where c.estado = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return consulta.list();
	}

}
