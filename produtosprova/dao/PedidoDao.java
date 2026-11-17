package produtosprova.dao;

import java.util.LinkedList;
import java.util.List;
import produtosprova.execptions.PedidoException;
import produtosprova.model.ItemPedido;
import produtosprova.model.Pedido;
import produtosprova.model.Produto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author emanuelary
 */
public class PedidoDao {
    private static List<Pedido> pedidos;
    
    public PedidoDao(){
        if(pedidos == null){
            pedidos = new LinkedList<>();
        }
    }
    
    public void gravar(Pedido p) throws PedidoException{
        for (ItemPedido item : p.getItens()) {
            Produto prod = item.getProduto();
            if (item.getQuantidade() > prod.getQtd()) {
                throw new PedidoException("Estoque insuficiente para: " + prod.getNome());
            }
            prod.setQtd(prod.getQtd() - item.getQuantidade());
        }
        pedidos.addLast(p);
    }
    
    public String listar() {
        int i = 1;
        String retorno = "";
        for (Pedido c : pedidos) {
            retorno += c.toString();
        }
        return retorno;
    }
}
