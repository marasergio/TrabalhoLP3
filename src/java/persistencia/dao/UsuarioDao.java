/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import org.hibernate.Session;
import persistencia.entidades.Usuario;
import persistencia.util.HibernateUtil;
import java.util.List;
/**
 *
 * @author Mara-Netbook
 */
public class UsuarioDao {
    public void salvar(Usuario usuario){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(usuario);
        session.getTransaction().commit();
        session.close();
    }
    
    public void delete(Usuario usuario){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.delete(usuario);
        session.getTransaction().commit();
        session.close();
    }
    
    public List<Usuario> listaUsuarios(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        List<Usuario> usuarios = session.createQuery("SELECT u FROM Usuario u").list();
        return usuarios;
    }
    
    public static void main(String[] args) {
        Usuario user = new Usuario();
        UsuarioDao dao = new UsuarioDao();
        user.setNome("mara");
        user.setEmail("mail@mail.com");
        user.setSenha("1234");
        
        dao.salvar(user);
    }
}
