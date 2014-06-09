package br.com.prajur.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.prajur.facade.CidadeFacade;
import br.com.prajur.modelo.Cidade;

@FacesConverter(value="cidadeConverter", forClass=Cidade.class)
public class CidadeConverter implements Converter {

	@Override  
	public Object getAsObject(FacesContext context, UIComponent component, String value) {  
		if (value != null && value.trim().length() > 0) { 
			int codigo = Integer.parseInt(value);
			try {  
				CidadeFacade cidadeRN = new CidadeFacade();
				Cidade cid = new Cidade();
				cid = cidadeRN.carregar(codigo);
				return cid;
			} catch (Exception e) {  
				throw new ConverterException("Não foi possível encontrar a Cidade de " + value + "." + e.getMessage());  
			}  
		}  
		return null;  
	}  

	@Override  
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if(value instanceof Cidade ) {
			Cidade cid = (Cidade) value;
			return String.valueOf(cid.getCodigo());    		
		}
		return "";
	}	

}
