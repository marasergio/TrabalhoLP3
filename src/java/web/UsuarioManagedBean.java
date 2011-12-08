/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencia.entidades.Usuario;
import java.util.List;
import persistencia.dao.UsuarioDao;
/**
 *
 * @author Mara-Netbook
 */
@ManagedBean(name="usuarioBean")
@SessionScoped
public class UsuarioManagedBean {
    private Usuario usuario;

    public UsuarioManagedBean() {
        this.usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String salvar() {
        UsuarioDao dao = new UsuarioDao();
        dao.salvar(usuario);
        usuario = new Usuario();
        return "USUARIO_SALVO";
    }
    
            
    
}
