/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;


import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    private List<Produto> produtos;
    private List<Item> itens;

    public PedidoManagedBean() {
        pedido = new Pedido();
    }

    public List<Pedido> getListaPedidos() {
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
    
    
}
