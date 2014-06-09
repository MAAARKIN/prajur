package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Triagem;

public interface TriagemDAO {
	public void salvar(Triagem triagem);
	public void atualizar(Triagem triagem);
	public void excluir(Triagem triagem);
	public Triagem carregar(int codigo);
	public List<Triagem> listar();
	public Triagem carregaTriagem(int codigo);
	public List<String> listarPoliticas(int codigo);
}
