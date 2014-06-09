package br.com.prajur.DAOHibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.prajur.DAO.ProfessorDAO;
import br.com.prajur.modelo.Estagiario;
import br.com.prajur.modelo.Pasta;
import br.com.prajur.modelo.Professor;
import br.com.prajur.modelo.Usuario;

public class ProfessorDAOHibernate implements ProfessorDAO {
	
	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}
	
	@Override
	public void salvar(Professor professor) {
		this.session.save(professor);		
	}

	@Override
	public void atualizar(Professor professor) {
		this.session.update(professor);		
	}

	@Override
	public void excluir(Professor professor) {
		this.session.delete(professor);		
	}

	@Override
	public Professor carregar(int codigo) {
		return (Professor) this.session.get(Professor.class, codigo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> listar() {
		return this.session.createCriteria(Professor.class).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Professor> professoresComCaso(int codigo) {
		String hql = "select p from Professor p, caso_com_professor cp, Caso c  where p.codigo = cp.professor_id and cp.caso_id = :codigo";
		Query consulta = this.session.createQuery(hql);
		consulta.setInteger("codigo", codigo);
		return (List<Professor>) consulta.list();
	}
	
}
