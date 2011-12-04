/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Mara
 */
@Entity
@Table(name="tb_cliente")
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="cli_id")
    private Long id;
    
    @Column(name="cli_nome")
    private String nome;
    
    @Column(name="cli_senha")
    private String senha;
    
    @Column(name="cli_email")
    private String email;
    
    @OneToMany(mappedBy="cliente", fetch= FetchType.LAZY)
    List<Pedido> pedidos =  new ArrayList<Pedido>();

    public Cliente() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String toString(){
        return this.nome;
    }
}
