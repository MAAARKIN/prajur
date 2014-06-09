package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.DocumentoDAO;
import br.com.prajur.modelo.Documento;

public class DocumentoDAOHibernate implements DocumentoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}	
	
	@Override
	public void salvar(Documento doc) {
		this.session.save(doc);		
	}

	@Override
	public void atualizar(Documento doc) {
		this.session.update(doc);		
	}

	@Override
	public void excluir(Documento doc) {
		this.session.delete(doc);		
	}

	@Override
	public Documento carregar(int codigo) {
		return (Documento) this.session.get(Documento.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documento> listar(int codigo) {
		String hql = "select d FROM Documento d WHERE d.codPasta = :parametro";
		Query consulta = session.createQuery(hql);
		consulta.setInteger("parametro", codigo);
		return (List<Documento>) consulta.list();
	}

}
