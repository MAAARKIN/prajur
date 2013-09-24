package br.com.prajur.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.prajur.facade.TipoMovimentoFacade;
import br.com.prajur.modelo.TipoMovimento;

@FacesConverter(value="tipoMovimentoConverter", forClass=TipoMovimento.class)
public class TipoMovConverter implements Converter {

	@Override  
	public Object getAsObject(FacesContext context, UIComponent component, String value) {  
		if (value != null && value.trim().length() > 0) { 
			int codigo = Integer.parseInt(value);
			try {
				TipoMovimentoFacade movRN = new TipoMovimentoFacade();
				TipoMovimento tipo = new TipoMovimento();
				tipo = movRN.carregar(codigo);
				return tipo;
			} catch (Exception e) {  
				throw new ConverterException("Não foi possível encontrar o Tipo de Movimento " + value + "." + e.getMessage());  
			}  
		}  
		return null;  
	}  

	@Override  
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if(value instanceof TipoMovimento ) {
			TipoMovimento tipo = (TipoMovimento) value;
			return String.valueOf(tipo.getCodigo());    		
		}
		return "";
	}

}
