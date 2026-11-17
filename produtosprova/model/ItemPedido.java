/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtosprova.model;

import produtosprova.execptions.ItemPedidoException;

/**
 *
 * @author emanuelary
 */
public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) throws ItemPedidoException{
        this.produto = produto;
        this.quantidade = quantidade;
        this.isValido();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }
    
    private void isValido() throws ItemPedidoException{
        if(this.quantidade > this.produto.getQtd()){
            throw new ItemPedidoException("Quantidade excede as reservas do estoque");
        }
    }

    @Override
    public String toString() {
        return quantidade +"x " + produto.getNome() + " - R$" + produto.getPreco() + '\n';
    }
    
    
}
