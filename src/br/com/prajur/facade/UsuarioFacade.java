package br.com.prajur.facade;

import java.util.List;

import br.com.prajur.DAO.UsuarioDAO;
import br.com.prajur.modelo.Usuario;
import br.com.prajur.util.DAOFactory;

public class UsuarioFacade {
	private UsuarioDAO usuarioDAO;
	
	public UsuarioFacade() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}
	
	public Usuario carregar(int codigo) {
		return this.usuarioDAO.carregar(codigo);
	}
	
	public Usuario buscaPorLogin(String login) {
		return this.usuarioDAO.buscaPorLogin(login);
	}
	
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		if(codigo == null|| codigo == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");
			usuario.setAtivo(true);
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}
	
	public void atualizar(Usuario usuario) {
		this.usuarioDAO.atualizar(usuario);
	}
	
	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}
	
	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}
}
