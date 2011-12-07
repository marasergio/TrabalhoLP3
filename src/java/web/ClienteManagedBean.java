/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import persistencia.dao.ClienteDao;
import persistencia.entidades.Cliente;

/**
 *
 * @author Mara
 */
@ManagedBean(name="clienteBean")
@SessionScoped
public class ClienteManagedBean {
    private Cliente cliente;
    private List<Cliente> listaClientes;
    
    public ClienteManagedBean(){
        this.cliente = new Cliente();
    }
    
    public String salveUpdate(){
        ClienteDao dao = new ClienteDao();
        dao.salveUpdate(cliente);
        this.cliente = new Cliente();
        return "SALVO_CLIENTE";
    }
    
    public void excluir(){
        ClienteDao dao =  new ClienteDao();
        dao.delete(cliente);
        cliente = new Cliente();        
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        ClienteDao dao = new ClienteDao();
        listaClientes = dao.listCliente();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    
    
}
