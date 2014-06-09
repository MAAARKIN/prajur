package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Procedimento;

public interface ProcedimentoDAO {
	
	public void salvar(Procedimento procedimento);
	public void atualizar(Procedimento procedimento);
	public void excluir(Procedimento procedimento);
	public Procedimento carregar(int codigo);
	public List<Procedimento> listar(int codigo);
	
}
