package br.com.prajur.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.prajur.facade.EstagiarioFacade;
import br.com.prajur.modelo.Estagiario;

@FacesConverter(value="estagiarioConverter", forClass=Estagiario.class)
public class EstagiarioConverter implements Converter {

	@Override  
	public Object getAsObject(FacesContext context, UIComponent component, String value) {  
		if (value != null && value.trim().length() > 0) { 
			int codigo = Integer.parseInt(value);
			try {
				EstagiarioFacade estRN = new EstagiarioFacade();
				Estagiario est = new Estagiario();
				est = estRN.carregar(codigo);
				return est;
			} catch (Exception e) {  
				throw new ConverterException("Não foi possível encontrar o estagiario " + value + "." + e.getMessage());  
			}  
		}  
		return null;  
	}  

	@Override  
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if(value instanceof Estagiario ) {
			Estagiario est = (Estagiario) value;
			return String.valueOf(est.getCodigo());    		
		}
		return "";
	}
}
