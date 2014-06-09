package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Professor;

public interface ProfessorDAO {
	public void salvar(Professor professor);
	public void atualizar(Professor professor);
	public void excluir(Professor professor);
	public Professor carregar(int codigo);
	public List<Professor> listar();
	public List<Professor> professoresComCaso(int codigo);
}
