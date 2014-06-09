package br.com.prajur.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prajur.facade.AdvogadoFacade;
import br.com.prajur.facade.CasoFacade;
import br.com.prajur.modelo.Advogado;
import br.com.prajur.modelo.Caso;

@ManagedBean(name="advogadoCasoBean")
@ViewScoped
public class AvogadoCasoBean implements Serializable {

	private static final long serialVersionUID = -7548634398115234890L;
	private Advogado advogado;
	private Caso caso;
	private List<Advogado> listar;
	
	public AvogadoCasoBean() {
		this.caso = new Caso();
		this.advogado = new Advogado();
	}
	
	public String salvar() {
		this.listar.add(advogado);
		this.caso.setAdvogado(listar);
		CasoFacade casoRN = new CasoFacade();
		casoRN.salvar(caso);
		this.advogado = new Advogado();
		return null;
	}
	
	public String excluir() {
		this.listar.remove(advogado);
		this.caso.setAdvogado(listar);
//		this.caso.getAdvogado().clear();
//		this.caso.getAdvogado().addAll(listar);
		CasoFacade casoRN = new CasoFacade();
		casoRN.salvar(caso);
		this.advogado = new Advogado();
		return null;
	}
	
	public void clean() {
		this.advogado = new Advogado();
		this.caso = new Caso();
	}
	
	public List<Advogado> getListar() {
		CasoFacade cf = new CasoFacade();
		this.listar = cf.advogadosComCaso(this.caso.getCodigo());
//		Collections.reverse(this.listar);
		return listar;
	}
	
	public List<Advogado> completeAdv(String query) {
		AdvogadoFacade advRN = new AdvogadoFacade();
		List<Advogado> profs = advRN.listar();
		List<Advogado> sugestao = new ArrayList<Advogado>();
		for(Advogado p : profs) {
			if(p.getNome().startsWith(query)) {
				sugestao.add(p);
			}
		}
		return sugestao;
	}

	public Advogado getAdvogado() {
		return advogado;
	}

	public void setAdvogado(Advogado advogado) {
		this.advogado = advogado;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public void setListar(List<Advogado> listar) {
		this.listar = listar;
	}
	
	
	
}
