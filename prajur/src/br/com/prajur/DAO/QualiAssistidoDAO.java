package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.QualiAssistido;

public interface QualiAssistidoDAO {
	public void salvar(QualiAssistido qualiAssistido);
	public void atualizar(QualiAssistido qualiAssistido);
	public void excluir(QualiAssistido qualiAssistido);
	public QualiAssistido carregar(int codigo);
	public List<QualiAssistido> listar(int codigo);
}
