package br.com.prajur.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prajur.facade.CasoFacade;
import br.com.prajur.facade.EstagiarioFacade;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Estagiario;

@ManagedBean(name="estagiarioCasoBean")
@ViewScoped
public class EstagiarioCasoBean implements Serializable {

	private static final long serialVersionUID = -5555255607915157553L;
	private Estagiario estagiario;
	private Caso caso;
	private List<Estagiario> listar;
	
	public EstagiarioCasoBean() {
		this.estagiario = new Estagiario();
		this.caso = new Caso();
	}
	
	public String salvar() {
		this.listar.add(estagiario);
		this.caso.setEstagiario(listar);
		CasoFacade casoRN = new CasoFacade();
		casoRN.salvar(caso);
		this.estagiario = new Estagiario();
		return null;
	}
	
	public String excluir() {
		this.listar.remove(estagiario);
		this.caso.setEstagiario(listar);
//		this.caso.getEstagiario().clear();
//		this.caso.getEstagiario().addAll(listar);
		CasoFacade casoRN = new CasoFacade();
		casoRN.salvar(caso);
		this.estagiario = new Estagiario();
		return null;
	}
	
	public void clean() {
		this.estagiario = new Estagiario();
		this.caso = new Caso();
	}
	
	public List<Estagiario> getListar() {
		CasoFacade cf = new CasoFacade();
		this.listar = cf.estagiariosComCaso(this.caso.getCodigo());
//		Collections.reverse(this.listar);
		return listar;
	}
	
	public List<Estagiario> completeEst(String query) {
		EstagiarioFacade estRN = new EstagiarioFacade();
		List<Estagiario> estagiarios = estRN.listar();
		List<Estagiario> sugestao = new ArrayList<Estagiario>();
		for(Estagiario p : estagiarios) {
			if(p.getNome().startsWith(query)) {
				sugestao.add(p);
			}
		}
		return sugestao;
	}

	public Estagiario getEstagiario() {
		return estagiario;
	}

	public void setEstagiario(Estagiario estagiario) {
		this.estagiario = estagiario;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public void setListar(List<Estagiario> listar) {
		this.listar = listar;
	}
	
	
}
