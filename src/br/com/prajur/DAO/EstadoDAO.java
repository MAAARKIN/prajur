package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Estado;

public interface EstadoDAO {
	public void salvar(Estado estado);
	public void atualizar(Estado estado);
	public void excluir(Estado estado);
	public Estado carregar(int codigo);
	public List<Estado> listar();
}
