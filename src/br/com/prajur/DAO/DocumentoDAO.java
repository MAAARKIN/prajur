package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Documento;

public interface DocumentoDAO {
	public void salvar(Documento doc);
	public void atualizar(Documento doc);
	public void excluir(Documento doc);
	public Documento carregar(int codigo);
	public List<Documento> listar(int codigo);
}
