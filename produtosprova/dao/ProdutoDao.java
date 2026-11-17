/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtosprova.dao;

import java.util.LinkedList;
import java.util.List;
import produtosprova.model.Produto;

/**
 *
 * @author emanuelary
 */
public class ProdutoDao {
    private static List<Produto> produtos;
    
    public ProdutoDao(){
        if(produtos == null){
            produtos = new LinkedList<>();
        }
    }
    
    public void gravar(Produto p){
        produtos.addLast(p);
    }
    
    public String listar() {
        int i = 1;
        String retorno = "";
        for (Produto c : produtos) {
            retorno += c.toString();
        }
        return retorno;
    }
}
