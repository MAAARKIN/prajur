package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.TipoProcedimento;

public interface TipoProcedimentoDAO {
	public void salvar(TipoProcedimento tipoAcao);
	public void atualizar(TipoProcedimento tipoAcao);
	public void excluir(TipoProcedimento tipoAcao);
	public TipoProcedimento carregar(int codigo);
	public List<TipoProcedimento> listar();
}
