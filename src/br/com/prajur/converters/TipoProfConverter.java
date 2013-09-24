package br.com.prajur.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.prajur.facade.ProfessorFacade;
import br.com.prajur.modelo.Professor;

@FacesConverter(value="professorConverter", forClass=Professor.class)
public class TipoProfConverter implements Converter {

	@Override  
	public Object getAsObject(FacesContext context, UIComponent component, String value) {  
		if (value != null && value.trim().length() > 0) { 
			int codigo = Integer.parseInt(value);
			try {
				ProfessorFacade profRN = new ProfessorFacade();
				Professor prof = new Professor();
				prof = profRN.carregar(codigo);
				return prof;
			} catch (Exception e) {  
				throw new ConverterException("Não foi possível encontrar o professor " + value + "." + e.getMessage());  
			}  
		}  
		return null;  
	}  

	@Override  
	public String getAsString(FacesContext context, UIComponent component, Object value) { 
		if(value instanceof Professor ) {
			Professor prof = (Professor) value;
			return String.valueOf(prof.getCodigo());    		
		}
		return "";
	}
}
