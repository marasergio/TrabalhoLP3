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
@Table(name="tb_pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ped_id")
    private Long id;
    
    @Column(name="ped_numero")
    private static int numero = 0;
    
    @Column(name="ped_total")
    private double total;
}
