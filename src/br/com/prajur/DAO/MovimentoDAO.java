package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Movimento;

public interface MovimentoDAO {
	public void salvar(Movimento movimento);
	public void atualizar(Movimento movimento);
	public void excluir(Movimento movimento);
	public Movimento carregar(int codigo);
	public List<Movimento> listar(int codigo);
}
