package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Pasta;

public interface PastaDAO {
	public void salvar(Pasta pasta);
	public void atualizar(Pasta pasta);
	public void excluir(Pasta pasta);
	public Pasta carregar(int codigo);
	public List<Pasta> listar(int codigo);
}
