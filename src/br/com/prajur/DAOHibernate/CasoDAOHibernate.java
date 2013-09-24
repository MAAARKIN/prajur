package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.CasoDAO;
import br.com.prajur.modelo.Advogado;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Estagiario;
import br.com.prajur.modelo.Professor;

public class CasoDAOHibernate implements CasoDAO {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Caso caso) {
		this.session.save(caso);
	}

	@Override
	public void atualizar(Caso caso) {
		this.session.update(caso);
	}

	@Override
	public void excluir(Caso caso) {
		this.session.delete(caso);
	}

	@Override
	public Caso carregar(int codigo) {
		return (Caso) this.session.get(Caso.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Caso> listar() {
		return this.session.createCriteria(Caso.class).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> casoProfessores(int codigo) {
		String hql = "select p from Caso c inner join c.professor p where c.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (List<Professor>) consulta.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Advogado> casoAdvogados(int codigo) {
		String hql = "select p from Caso c inner join c.advogado p where c.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (List<Advogado>) consulta.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Estagiario> casoEstagiarios(int codigo) {
		String hql = "select p from Caso c inner join c.estagiario p where c.codigo = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (List<Estagiario>) consulta.list();
	}

}