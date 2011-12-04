/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import java.util.List;
import org.hibernate.Session;
import persistencia.entidades.Cliente;
import persistencia.util.HibernateUtil;

/**
 *
 * @author Mara
 */
public class ClienteDao {
    public void salveUpdate(Cliente cliente){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(cliente);
        session.getTransaction().commit();
        session.close();
    }
    
     public void delete(Cliente cliente){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.delete(cliente);
        session.getTransaction().commit();
        session.close();
    } 
     public List<Cliente> listCliente(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        List<Cliente> clientes = session.createQuery("SELECT c FROM Cliente c").list();
        session.close();
        return clientes;
    }
     
     public Cliente getCliente(Long id){
         Session session = HibernateUtil.getSession();
         session.beginTransaction().begin();
         return (Cliente) session.get(Cliente.class, id);
     }
     
     public static void main(String[] args) {
        Cliente c = new Cliente();
           c.setNome("Nina");     
        ClienteDao dao = new ClienteDao();
    
        c = dao.getCliente(1L);
         System.out.println(c);
       
        //dao.salveUpdate(c);
    }
     
}
