/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtosprova.model;

import java.util.ArrayList;

/**
 *
 * @author emanuelary
 */
public class Pedido {
    private int codigo;
    private static int geradorCodigo = 0;
    private ArrayList<ItemPedido> itens;
    
    public Pedido(){
        this.codigo = geradorCodigo++;
        this.itens = new ArrayList<>();
    }

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }

    public void addItem(ItemPedido item) {
        this.itens.add(item);
    }
    
    public String listarItens() {
        String retorno = "";
        for (ItemPedido c : itens) {
            retorno += c.toString();
        }
        return retorno;
    }
    
    public Double getTotalPedido(){
        Double retorno = 0.0;
        for (ItemPedido c : itens) {
            retorno += c.getSubtotal();
        }
        return retorno;
    }
}
