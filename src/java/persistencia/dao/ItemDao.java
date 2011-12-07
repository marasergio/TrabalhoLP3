/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import org.hibernate.Session;
import persistencia.util.HibernateUtil;

/**
 *
 * @author Mara
 */
public class ItemDao {

    private static class Item {

        public Item() {
        }
    }
    public void salveUpdate(Item item){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(item);
        session.getTransaction().commit();
    }
    
    public void delete(Item item){
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.delete(item);
        session.getTransaction().commit();
    }
}
