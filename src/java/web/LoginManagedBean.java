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
@SessionScoped
public class LoginManagedBean {

    private Usuario usuario;
    private List<Usuario> usuarios;

    public LoginManagedBean() {
        usuario = new Usuario();
    }

    /** Creates a new instance of Login */
    public String logar() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = ((HttpServletRequest) externalContext.getRequest()).getSession();


        // validar se usuário é válido
        for (Usuario user : getUsuarios()) {
            if (user.getEmail().equals(usuario.getEmail()) && 
                    user.getSenha().equals(usuario.getSenha())) {
                session.setAttribute("LOGADO", "SIM");
                return "LOGADO";
            }
        }
        return "NAO_LOGADO";

    }

    public String salvar() {
        UsuarioDao dao = new UsuarioDao();
        dao.salvar(usuario);
        usuario = new Usuario();
        return "USUARIO_SALVO";
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

    public List<Usuario> getUsuarios() {
        UsuarioDao dao = new UsuarioDao();
        usuarios = dao.listaUsuarios();
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
