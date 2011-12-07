/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.entidades;

import javax.persistence.*;

/**
 *
 * @author Mara-Netbook
 */
@Entity
@Table(name="tb_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="usu_id")
    private Long id;
    
    @Column(name="usu_nome")
    private String nome;
    
    @Column(name="usu_email")
    private String email;
    
    @Column(name="usu_senha")
    private String senha;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
