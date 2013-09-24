package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.TipoMovimento;

public interface TipoMovimentoDAO {
	public void salvar(TipoMovimento tipoMovimento);
	public void atualizar(TipoMovimento tipoMovimento);
	public void excluir(TipoMovimento tipoMovimento);
	public TipoMovimento carregar(int codigo);
	public List<TipoMovimento> listar();
}
