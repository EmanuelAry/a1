/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtosprova.model;

/**
 *
 * @author emanuelary
 */
public class Produto {
    private int codigo;
    private static int geradorCodigo = 0;
    private String nome;
    private String desc;
    private int qtd;
    private double preco;

    public Produto(String nome, String desc, int qtd, double preco) {
        this.codigo = geradorCodigo++;
        this.nome = nome;
        this.desc = desc;
        this.qtd = qtd;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return codigo + " - " + nome + " - " + desc + " - qtd:" + qtd + " - "+ "R$" + preco + '\n';
    }
    
}
