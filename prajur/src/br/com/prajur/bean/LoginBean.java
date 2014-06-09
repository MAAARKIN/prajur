package br.com.prajur.bean;

import java.io.IOException;  
import java.io.Serializable;

import javax.faces.bean.ManagedBean;  
import javax.faces.bean.SessionScoped;  
import javax.faces.context.ExternalContext;  
import javax.faces.context.FacesContext;  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
  
@ManagedBean(name="loginBean")
@SessionScoped  
public class LoginBean implements Serializable {  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8792233151586734878L;
	private String username;  
    private String password;  
    public LoginBean() {
    	
    }  
    public String doLogin() throws IOException, ServletException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
 
        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                 .getRequestDispatcher("/j_spring_security_check");
 
        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());
 
        FacesContext.getCurrentInstance().responseComplete();
        // It's OK to return null here because Faces is just going to exit.
        return null;
    }
    
    public String getPassword() {  
        return password;  
    }  
    public String getUsername() {  
        return username;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public void setUsername(String username) {  
        this.username = username;  
    }  
} 