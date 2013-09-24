package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.ParteContrariaDAO;
import br.com.prajur.modelo.ParteContraria;

public class ParteContrariaDAOHibernate implements ParteContrariaDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(ParteContraria parteContraria) {
		this.session.save(parteContraria);		
	}

	@Override
	public void atualizar(ParteContraria parteContraria) {
		this.session.update(parteContraria);		
	}

	@Override
	public void excluir(ParteContraria parteContraria) {
		this.session.delete(parteContraria);
	}

	@Override
	public ParteContraria carregar(int codigo) {
		return (ParteContraria) this.session.get(ParteContraria.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ParteContraria> listar(int codigo) {
		String hql = "select p FROM ParteContraria p WHERE p.pastaContraria = :parametro";
		Query consulta = session.createQuery(hql);
		consulta.setInteger("parametro", codigo);
		return (List<ParteContraria>) consulta.list();
	}

}
