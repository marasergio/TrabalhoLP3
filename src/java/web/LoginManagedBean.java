/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import persistencia.entidades.Usuario;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import persistencia.dao.UsuarioDao;

/**
 *
 * @author Mara
 */
@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginManagedBean {
    private Usuario usuario;

    public LoginManagedBean() {
        usuario = new Usuario();
    }

    /** Creates a new instance of Login */
    public String logar() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = ((HttpServletRequest) externalContext.getRequest()).getSession();

        List<Usuario> usuarios = new UsuarioDao().listaUsuarios();

        // validar se usuário é válido
        for (Usuario user : usuarios) {
            if (user.getEmail().equals(usuario.getEmail()) && 
                    user.getSenha().equals(usuario.getSenha())) {
                session.setAttribute("LOGADO", "SIM");
                return "LOGADO";
            }
        }
        return "NAO_LOGADO";

    }

    /** Creates a new instance of Login */
    public String logoff() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = ((HttpServletRequest) externalContext.getRequest()).getSession();
        session.setAttribute("LOGADO", "NAO");
        return "LOGOFF";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
