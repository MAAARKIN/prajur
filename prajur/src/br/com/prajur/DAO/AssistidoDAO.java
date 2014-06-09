package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Assistido;

public interface AssistidoDAO {
	public void salvar(Assistido assistido);
	public void atualizar(Assistido assistido);
	public void excluir(Assistido assistido);
	public Assistido carregar(int codigo);
	public List<Assistido> listar();
}
