package br.com.prajur.bean;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.prajur.facade.MovimentoFacade;
import br.com.prajur.facade.TipoMovimentoFacade;
import br.com.prajur.modelo.Caso;
import br.com.prajur.modelo.Movimento;
import br.com.prajur.modelo.TipoMovimento;

@ManagedBean(name="movimentoCasoBean")
@ViewScoped
public class MovimentoCasoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9095424076801704439L;
	private Movimento mov;
	private Caso caso;
	private List<Movimento> listar;
	private Date data = new Date(System.currentTimeMillis());
	private SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyyy");
	
	public MovimentoCasoBean() {
		this.mov = new Movimento();
		this.caso = new Caso();
	}
	
	public String salvar() {
		this.mov.setDataModificacao(formatarDate.format(data));
		this.mov.setCodigoProcesso(this.caso);
		MovimentoFacade movRN = new MovimentoFacade();
		movRN.salvar(this.mov);
		this.mov = new Movimento();
		return null;
	}
	
	public void clean() {
		this.mov = new Movimento();
		this.caso = new Caso();
	}

	public Movimento getMov() {
		return mov;
	}

	public void setMov(Movimento mov) {
		this.mov = mov;
	}

	public Caso getCaso() {
		return caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public List<Movimento> getListar() {
		MovimentoFacade movRN = new MovimentoFacade();
		this.listar = movRN.listar(this.caso.getCodigo());
		Collections.reverse(listar);
		return this.listar;
	}
	
	public List<TipoMovimento> completeMov(String query) {
		TipoMovimentoFacade tipoMovRN = new TipoMovimentoFacade();
		List<TipoMovimento> lista = tipoMovRN.listar();
		List<TipoMovimento> sugestao = new ArrayList<TipoMovimento>();
		for(TipoMovimento p : lista) {
			if(p.getDescricao().startsWith(query)) {
				sugestao.add(p);
			}
		}
		return sugestao;
	}
}
