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
@Table(name="tb_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="prod_id")
    private Long id;
    
    @Column(name="prod_descricao")
    private String descricao;
    
    @Column(name="prod_preco")
    private double preco;
    
    public Produto() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
