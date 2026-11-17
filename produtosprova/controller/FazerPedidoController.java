/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtosprova.controller;

import produtosprova.dao.PedidoDao;
import produtosprova.execptions.ItemPedidoException;
import produtosprova.execptions.PedidoException;
import produtosprova.model.ItemPedido;
import produtosprova.model.Pedido;
import produtosprova.model.Produto;
import produtosprova.view.FazerPedidoView;

/**
 *
 * @author emanuelary
 */
public class FazerPedidoController {
    private FazerPedidoView view;
    private PedidoDao dao;
    private Pedido model; 
    
    public FazerPedidoController(){
        this.dao = new PedidoDao();
        this.view = new FazerPedidoView();
        this.model = new Pedido();
        this.adicionarAcoes();
    }
    
    public void exibirTela(){
        this.view.setVisible(true);
    }
    
    public void adicionarAcoes(){
       view.adicionarAcaoBtnAdicionarProduto(e -> acaoAdicionarProduto());
       view.adicionarAcaoBtnFinalizarPedido(e -> acaoFinalizarPedido());;
       view.adicionarAcaoBtnCancelarPedido(e -> acaoCancelarPedido());
    }
    
    public void acaoAdicionarProduto(){
        try{
            Produto produto = view.getProduto();
            int qtd = view.getQtdProduto();
            ItemPedido item = new ItemPedido(produto, qtd);
            this.model.addItem(item);
            this.view.limparCampos();
            this.view.atualisListagem(this.model.listarItens());
            this.view.atualizaTotal(this.model.getTotalPedido());
        }catch(ItemPedidoException e){
            view.exibirMensagem(e.getMessage());
        }
    }
    
    public void acaoFinalizarPedido(){
        try{
            this.dao.gravar(this.model);
            this.view.limparCampos();
            this.view.atualisListagem("");
            this.view.atualizaTotal(0);
            this.model = new Pedido();
        }catch(PedidoException e ){
            view.exibirMensagem(e.getMessage());
        }
        
    }
    
    public void acaoCancelarPedido(){
        //
    }
    
}
