/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mara
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginManagedBean {

    private String email;
    private String senha;

    public LoginManagedBean() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

       /** Creates a new instance of Login */
    public String logar() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = ((HttpServletRequest) externalContext.getRequest()).getSession();
        if (this.email.equals("mara") && this.senha.equals("mara123")) {
            session.setAttribute("LOGADO", "SIM");
            return "LOGADO";
        }
        return "NAO_LOGADO";
        
    }


    /** Creates a new instance of Login */
    public String logoff() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = ((HttpServletRequest) externalContext.getRequest()).getSession();
        session.setAttribute("LOGADO", "nonom");
        return "LOGOFF";
    }

    
}
