/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package produtosprova;

import produtosprova.controller.ManterProdutoController;
import produtosprova.dao.ProdutoDao;
import produtosprova.model.Produto;
import produtosprova.view.ManterProdutoView;

/**
 *
 * @author emanuelary
 */
public class ProdutosProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ManterProdutoController ManterProdutoController = new ManterProdutoController();
        ManterProdutoController.exibirTela();
    }
    
}
