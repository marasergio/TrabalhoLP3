/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Mara
 */
@Entity
@Table(name="tb_pedido")
public class Pedido implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ped_id")
    private Long id;
    
    @Column(name="ped_numero")
    private int numero;
    
    @Column(name="ped_total")
    private double total;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;
    
    @OneToMany(mappedBy="pedido")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private List<Item> itens = new ArrayList<Item>();

    public Pedido() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getTotal() {
        this.setTotal(this.totalPedido());
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double totalPedido(){
        double tPedido = 0;
        for(Item item : itens){
            tPedido += item.getValor();
        }
        return tPedido;
    }
}
