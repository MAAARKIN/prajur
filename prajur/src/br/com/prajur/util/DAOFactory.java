package br.com.prajur.util;

import br.com.prajur.DAO.AdvogadoDAO;
import br.com.prajur.DAO.AssistidoDAO;
import br.com.prajur.DAO.CasoDAO;
import br.com.prajur.DAO.DocumentoDAO;
import br.com.prajur.DAO.EstagiarioDAO;
import br.com.prajur.DAO.MovimentoDAO;
import br.com.prajur.DAO.ParteContrariaDAO;
import br.com.prajur.DAO.PastaDAO;
import br.com.prajur.DAO.ProcedimentoDAO;
import br.com.prajur.DAO.ProfessorDAO;
import br.com.prajur.DAO.QualiAssistidoDAO;
import br.com.prajur.DAO.TipoMovimentoDAO;
import br.com.prajur.DAO.TipoProcedimentoDAO;
import br.com.prajur.DAO.TriagemDAO;
import br.com.prajur.DAO.UsuarioDAO;
import br.com.prajur.DAOHibernate.AdvogadoDAOHibernate;
import br.com.prajur.DAOHibernate.AssistidoDAOHibernate;
import br.com.prajur.DAOHibernate.CasoDAOHibernate;
import br.com.prajur.DAOHibernate.DocumentoDAOHibernate;
import br.com.prajur.DAOHibernate.EstagiarioDAOHibernate;
import br.com.prajur.DAOHibernate.MovimentoDAOHibernate;
import br.com.prajur.DAOHibernate.ParteContrariaDAOHibernate;
import br.com.prajur.DAOHibernate.PastaDAOHibernate;
import br.com.prajur.DAOHibernate.ProcedimentoDAOHibernate;
import br.com.prajur.DAOHibernate.ProfessorDAOHibernate;
import br.com.prajur.DAOHibernate.QualiAssistidoDAOHibernate;
import br.com.prajur.DAOHibernate.TipoMovimentoDAOHibernate;
import br.com.prajur.DAOHibernate.TipoProcedimentoDAOHibernate;
import br.com.prajur.DAOHibernate.TriagemDAOHibernate;
import br.com.prajur.DAOHibernate.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO;
	}

	public static EstagiarioDAO criarEstagiarioDAO() {
		EstagiarioDAOHibernate estagiarioDAO = new EstagiarioDAOHibernate();
		estagiarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return estagiarioDAO;
	}

	public static AdvogadoDAO criarAdvogadoDAO() {
		AdvogadoDAOHibernate advogadoDAO = new AdvogadoDAOHibernate();
		advogadoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return advogadoDAO;
	}
	
	public static TipoProcedimentoDAO criarTipoProcedimentoDAO() {
		TipoProcedimentoDAOHibernate tipoAcaoDAO = new TipoProcedimentoDAOHibernate();
		tipoAcaoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return tipoAcaoDAO;
	}
	
	public static TipoMovimentoDAO criarTipoMovimentoDAO() {
		TipoMovimentoDAOHibernate tipoMovDAO = new TipoMovimentoDAOHibernate();
		tipoMovDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return tipoMovDAO;
	}
	
	public static AssistidoDAO criarAssitidoDAO() {
		AssistidoDAOHibernate assistidoDAO = new AssistidoDAOHibernate();
		assistidoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return assistidoDAO;
	}
	
	public static PastaDAO criarPastaDAO() {
		PastaDAOHibernate PastaDAO = new PastaDAOHibernate();
		PastaDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return PastaDAO;
	}
	
	public static QualiAssistidoDAO criarQualiDAO() {
		QualiAssistidoDAOHibernate qualiDAO = new QualiAssistidoDAOHibernate();
		qualiDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return qualiDAO;
	}
	
	public static ParteContrariaDAO criarParteDAO() {
		ParteContrariaDAOHibernate parteDAO = new ParteContrariaDAOHibernate();
		parteDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return parteDAO;
	}
	
	public static DocumentoDAO criarDocumentoDAO() {
		DocumentoDAOHibernate docDAO = new DocumentoDAOHibernate();
		docDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return docDAO;
	}
	
	public static TriagemDAO criarTriagemDAO() {
		TriagemDAOHibernate triDAO = new TriagemDAOHibernate();
		triDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return triDAO;
	}
	
	public static ProfessorDAO criarProfessorDAO() {
		ProfessorDAOHibernate profDAO = new ProfessorDAOHibernate();
		profDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return profDAO;
	}
	
	public static CasoDAO criarCasoDAO() {
		CasoDAOHibernate casoDAO = new CasoDAOHibernate();
		casoDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return casoDAO;
	}
	
	public static ProcedimentoDAO criarProcedimentoDAO() {
		ProcedimentoDAOHibernate procDAO = new ProcedimentoDAOHibernate();
		procDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return procDAO;
	}
	
	public static MovimentoDAO criarMovimentoDAO() {
		MovimentoDAOHibernate movDAO = new MovimentoDAOHibernate();
		movDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return movDAO;
	}

}
