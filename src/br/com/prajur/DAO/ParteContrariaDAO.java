package br.com.prajur.DAO;

import java.util.List;

import br.com.prajur.modelo.ParteContraria;

public interface ParteContrariaDAO {
	public void salvar(ParteContraria parteContraria);
	public void atualizar(ParteContraria parteContraria);
	public void excluir(ParteContraria parteContraria);
	public ParteContraria carregar(int codigo);
	public List<ParteContraria> listar(int codigo);
}
