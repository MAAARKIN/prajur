package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Advogado;

public interface AdvogadoDAO {
	public void salvar(Advogado advogado);
	public void atualizar(Advogado advogado);
	public void excluir(Advogado advogado);
	public Advogado carregar(int codigo);
	public List<Advogado> listar();
}