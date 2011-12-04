/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import javax.persistence.*;

/**
 *
 * @author Mara
 */
@Entity
@Table(name="tb_item")
public class Item {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="item_id")
    private Long id;
    @Column(name="item_quantidade")
    private int quantidade;
    @Column(name="item_valor")
    private double valor;
    
    @ManyToOne
    @JoinColumn(name="id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;

    public Item() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
