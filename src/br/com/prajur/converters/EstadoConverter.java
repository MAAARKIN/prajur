package br.com.prajur.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.prajur.facade.EstadoFacade;
import br.com.prajur.modelo.Estado;

@FacesConverter(value="estadoConverter", forClass=Estado.class)
public class EstadoConverter implements Converter {

	@Override  
	public Object getAsObject(FacesContext context, UIComponent component, String value) {  
		if (value != null && value.trim().length() > 0) { 
			int codigo = Integer.parseInt(value);
			try {  
				EstadoFacade estadoRN = new EstadoFacade();
				Estado est = new Estado();
				est = estadoRN.carregar(codigo);
				return est;
			} catch (Exception e) {  
				throw new ConverterException("Não foi possível encontrar o Estado de " + value + "." + e.getMessage());  
			}  
		}  
		return null;  
	}  

	@Override  
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if(value instanceof Estado ) {
			Estado est = (Estado) value;
			return String.valueOf(est.getCodigo());    		
		}
		return "";
	}
}