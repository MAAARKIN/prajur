package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.Advogado;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Estagiario;
import br.com.prajur.modelo.Professor;

public interface CasoDAO {
	public void salvar(Caso caso);
	public void atualizar(Caso caso);
	public void excluir(Caso caso);
	public Caso carregar(int codigo);
	public List<Caso> listar();
	public List<Professor> casoProfessores(int codigo);
	public List<Advogado> casoAdvogados(int codigo);
	public List<Estagiario> casoEstagiarios(int codigo);
}
