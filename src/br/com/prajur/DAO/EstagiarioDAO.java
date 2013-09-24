package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Estagiario;

public interface EstagiarioDAO {
	public void salvar(Estagiario estagiario);
	public void atualizar(Estagiario estagiario);
	public void excluir(Estagiario estagiario);
	public Estagiario carregar(int codigo);
	public List<Estagiario> listar();
}
