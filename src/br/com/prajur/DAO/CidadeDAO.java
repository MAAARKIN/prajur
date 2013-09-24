package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Cidade;

public interface CidadeDAO {
	public void salvar(Cidade cidade);
	public void atualizar(Cidade cidade);
	public void excluir(Cidade cidade);
	public Cidade carregar(int codigo);
	public List<Cidade> listar(int codigo);
}
