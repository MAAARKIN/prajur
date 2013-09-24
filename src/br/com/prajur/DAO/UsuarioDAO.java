package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Usuario;

public interface UsuarioDAO {
	public void salvar(Usuario usuario);
	public void atualizar(Usuario usuario);
	public void excluir(Usuario usuario);
	public Usuario carregar(int codigo);
	public Usuario buscaPorLogin(String login);
	public List<Usuario> listar();
}
