/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import persistencia.dao.ProdutoDao;
import persistencia.entidades.Produto;


/**
 *
 * @author Mara
 */
@ManagedBean(name="produtoBean")
@SessionScoped
public class ProdutoManagedBean {
    private Produto produto;
    private List<Produto> listaProdutos;

    public ProdutoManagedBean() {
        produto = new Produto();
    }

    public List<Produto> getListaProdutos() {
        ProdutoDao dao = new ProdutoDao();
        this.listaProdutos = dao.listProduto();
        return this.listaProdutos;
    }

    
    public Produto getProduto() {
        return produto;
    }
    
    public String salvar(){
        ProdutoDao dao = new ProdutoDao();
        dao.salveUpdate(produto);
        this.produto = new Produto();
        return "produto_salvo";
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
        
   
}
