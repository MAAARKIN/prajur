package br.com.prajur.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.prajur.facade.TipoProcedimentoFacade;
import br.com.prajur.modelo.TipoProcedimento;

@FacesConverter(value="tipoProcedimentoConverter", forClass=TipoProcedimento.class)
public class TipoProcedConverter implements Converter {

	@Override  
	public Object getAsObject(FacesContext context, UIComponent component, String value) {  
		if (value != null && value.trim().length() > 0) { 
			int codigo = Integer.parseInt(value);
			try {
				TipoProcedimentoFacade procRN = new TipoProcedimentoFacade();
				TipoProcedimento tipo = new TipoProcedimento();
				tipo = procRN.carregar(codigo);
				return tipo;
			} catch (Exception e) {  
				throw new ConverterException("Não foi possível encontrar o Tipo de Procedimento " + value + "." + e.getMessage());  
			}  
		}  
		return null;  
	}  

	@Override  
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if(value instanceof TipoProcedimento ) {
			TipoProcedimento tipo = (TipoProcedimento) value;
			return String.valueOf(tipo.getCodigo());    		
		}
		return "";
	}

}
