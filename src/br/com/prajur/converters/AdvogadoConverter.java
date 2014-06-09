package br.com.prajur.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.prajur.facade.AdvogadoFacade;
import br.com.prajur.modelo.Advogado;

@FacesConverter(value="advogadoConverter", forClass=Advogado.class)
public class AdvogadoConverter implements Converter {

	@Override  
	public Object getAsObject(FacesContext context, UIComponent component, String value) {  
		if (value != null && value.trim().length() > 0) { 
			int codigo = Integer.parseInt(value);
			try {
				AdvogadoFacade advRN = new AdvogadoFacade();
				Advogado est = new Advogado();
				est = advRN.carregar(codigo);
				return est;
			} catch (Exception e) {  
				throw new ConverterException("Não foi possível encontrar o advogado " + value + "." + e.getMessage());  
			}  
		}  
		return null;  
	}  

	@Override  
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if(value instanceof Advogado ) {
			Advogado adv = (Advogado) value;
			return String.valueOf(adv.getCodigo());    		
		}
		return "";
	}

}
