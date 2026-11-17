/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaprova.model;

/**
 *
 * @author emanuelary
 */
public class Contato implements Comparable<Contato> {
    private int id;
    private static int geradorId = 0;
    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.id = geradorId++;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato{" + "id=" + id + ", nome=" + nome + ", telefone=" + telefone + "}/n";
    }

    @Override
    public int compareTo(Contato o) {
        if (this.nome == null && o.getNome() == null) {
            return 0;
        }
        if (this.nome == null) {
            return -1;
        }
        if (o.getNome() == null) {
            return 1;
        }
        return this.nome.compareToIgnoreCase(o.getNome());
    }
    
    
}
