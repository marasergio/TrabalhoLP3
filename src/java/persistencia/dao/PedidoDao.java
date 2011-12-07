/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import persistencia.entidades.*;
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
     
     public static void main(String[] args) {
        Pedido pedido = new Pedido();
        
        Cliente cliente = new ClienteDao().getCliente(1L);
        
        Produto p1 = new ProdutoDao().getProduto(1L);
        Produto p2 = new ProdutoDao().getProduto(2L);
        
        List<Item> itens = new ArrayList<Item>();
        Item i1 = new Item();
        Item i2 = new Item();
        
        i1.setPedido(pedido);
        i1.setProduto(p1);
        i1.setQuantidade(2);
        i1.setValor(i1.getQuantidade()*i1.getProduto().getPreco());
        
        i2.setPedido(pedido);
        i2.setProduto(p2);
        i2.setQuantidade(2);
        i2.setValor(i2.getQuantidade()*i2.getProduto().getPreco());
        
        itens.add(i1);
        itens.add(i2);
        
        pedido.setCliente(cliente);
        //pedido.setId(1L);
        pedido.setNumero(001);
        pedido.setTotal(000);
        pedido.setItens(itens);
        
        PedidoDao dao = new PedidoDao();
        dao.salveUpdate(pedido);
        //ItemDao iDao = new ItemDao();
        //iDao.salveUpdate(i2);
        System.out.println("salvo com sucesso");
        
    }
    
}
