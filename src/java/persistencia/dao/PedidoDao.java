/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import java.util.List;
import org.hibernate.Session;
import persistencia.entidades.Pedido;
import persistencia.util.HibernateUtil;

/**
 *
 * @author Mara
 */
public class PedidoDao {
    public void salveUpdate(Pedido pedido){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(pedido);
        session.getTransaction().commit();
        session.close();
    }
    
     public void delete(Pedido pedido){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.delete(pedido);
        session.getTransaction().commit();
        session.close();
    } 
     public List<Pedido> listPedido(){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        List<Pedido> pedidos = session.createQuery("SELECT p FROM Pedido p").list();
        return pedidos;
    }
    
}
