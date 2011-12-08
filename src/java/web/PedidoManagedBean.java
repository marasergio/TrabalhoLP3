/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import persistencia.dao.PedidoDao;
import persistencia.entidades.*;

/**
 *
 * @author Mara
 */
@ManagedBean(name="pedidoBean")
@SessionScoped
public class PedidoManagedBean {
    private Pedido pedido;
    private List<Pedido> listaPedidos;
    private Item item;

    public PedidoManagedBean() {
        pedido = new Pedido();
        item = new Item();
    }

    public List<Pedido> getListaPedidos() {
        PedidoDao dao = new PedidoDao();
        listaPedidos = dao.listPedido();
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
    
    public String novoPedido(){
        pedido = new Pedido();
        return "NOVO_PEDIDO";
    }
    public String addCarrinho(){
        //item.setValor(item.valorItem());         
       // pedido.setTotal(pedido.totalPedido());
        
        pedido.getItens().add(item);
        item = new Item();
        return "ITEM_ADICIONADO";
    }
    
    public String salvarPedido(){
        PedidoDao dao = new PedidoDao();
        dao.salveUpdate(pedido);
        pedido = new Pedido();
        return "PEDIDO_SALVO";
    }
     
    
    
}
