/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtosprova.controller;

import produtosprova.dao.ProdutoDao;
import produtosprova.execptions.ProdutoException;
import produtosprova.model.Produto;
import produtosprova.view.ManterProdutoView;

/**
 *
 * @author emanuelary
 */
public class ManterProdutoController {
    private ManterProdutoView view;
    private Produto model;
    private ProdutoDao dao;
    
    public ManterProdutoController(){
        this.view = new ManterProdutoView();
        this.dao = new ProdutoDao();
        this.adicionarAcoes();
    }
    
    public void exibirTela(){
        this.view.setVisible(true);
    }
    
    public void adicionarAcoes(){
       view.adicionarAcaoBtnCadastrarProduto(e -> acaoCadastrarProduto());
   }
    
   public void acaoCadastrarProduto(){
       try{
           this.model = this.getDadosProdutoFromView();
           this.dao.gravar(model);
           this.view.exibirMensagem("Produto cadastrado com sucesso!");
           this.view.limparCampos();
           this.view.atualisListagem(this.dao.listar());
       }catch(ProdutoException e){
           view.exibirMensagem(e.getMessage());
       }
   }
   
   private Produto getDadosProdutoFromView() throws ProdutoException{
       String nome = view.getNomeProduto();
       String desc = view.getDescProduto();
       String preco = view.getPrecoProduto();
       int qtd = view.getQtdProduto();
       
       if(nome.isBlank() || desc.isBlank() || preco.isBlank() || qtd < 0){
           throw new ProdutoException("Todos os campos de produto devem ser preenchidos.");
       }
       try{
           String limpo = preco.trim().replace(".", "").replace(",", ".");
           double precoDouble = Double.parseDouble(limpo);
           Produto produto = new Produto(nome, desc, qtd, precoDouble);
           return produto;
       }catch(NumberFormatException e){
           throw new ProdutoException("O preço deve ser um numero no padrão 12,23");
       }
   } 
}
