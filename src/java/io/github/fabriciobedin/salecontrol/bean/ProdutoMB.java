/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.fabriciobedin.salecontrol.bean;

import io.github.fabriciobedin.salecontrol.entity.Compra;
import io.github.fabriciobedin.salecontrol.entity.Compraproduto;
import io.github.fabriciobedin.salecontrol.entity.Produto;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author fabricio
 */
@ManagedBean
@SessionScoped    //enquanto a seção estiver ativa, os dados se mantem
public class ProdutoMB {
     private Produto produto = new Produto();
     private Compraproduto compraProduto = new Compraproduto();
     private Compra compra = new Compra();
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private List<Compraproduto> compraProdutos = new ArrayList<Compraproduto>();
    
    
    public void adicionarProduto(){
        //adicionando um contato dentro da lista produtos
                       
        produtos.add(produto);
              
        //criando mensagem para exibir
        String msg = "Produto adicionado com sucesso!";
              
        //capturando mensagem criada
        FacesMessage fm = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, fm);
        
        //criando um nova produto
        produto = new Produto();
                
    }
    public void compraProduto(){
        //adicionando um contato dentro da lista produtos
        compraProdutos.add(compraProduto);
              
        //criando mensagem para exibir
        String msg = "Nova Venda Iniciada!";
              
        //capturando mensagem criada
        FacesMessage fm = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, fm);
        
        //criando um nova produto
        compraProduto = new Compraproduto();
                
    }
    public void compra(){
        //adicionando um contato dentro da lista produtos
        compra.setCmpDatahora(getData());
        compraProdutos.add(compraProduto);
        
        //criando mensagem para exibir
        String msg = "Compra efetuada com sucesso!";
              
        //capturando mensagem criada
        FacesMessage fm = new FacesMessage(msg);
        FacesContext.getCurrentInstance().addMessage(msg, fm);
        
        //criando um nova produto
        compraProduto = new Compraproduto();
                
    }
    
    public Timestamp getData(){
        return new Timestamp(System.currentTimeMillis());
    }

    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
