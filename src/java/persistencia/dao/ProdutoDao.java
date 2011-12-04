/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import persistencia.entidades.Produto;
import persistencia.util.HibernateUtil;

/**
 *
 * @author Mara
 */
public class ProdutoDao {

    public void salveUpdate(Produto produto) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.saveOrUpdate(produto);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Produto produto) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        session.delete(produto);
        session.getTransaction().commit();
        session.close();
    }

    public List<Produto> listProduto() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        List<Produto> pedidos = session.createQuery("SELECT p FROM Produto p").list();
        return pedidos;
    }

    public List<Produto> buscarProduto(String nome) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction().begin();
        
        String hql = "SELECT p FROM Produto p WHERE  p.nome Like :nome";
        Query query = session.createQuery(hql);
        query.setString("nome", "%"+nome+"%");
        
        return query.list();
    }

    public static void main(String[] args) {
        Produto p = new Produto();
        //p.setPreco(15.20);
        p.setNome("coca cola");
        
        ProdutoDao dao = new ProdutoDao();
        for(Produto prod : dao.buscarProduto("uar")){
            System.out.println(prod.getNome());
        }
    }
}
