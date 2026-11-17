/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agendaprova.dao;

import agendaprova.model.Contato;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author emanuelary
 */
public class AgendaDao implements IAgendaDao {
    private static LinkedList<Contato> contatos;
    
    public AgendaDao(){
        if(contatos == null)
            contatos = new LinkedList<>();
    }
    
//    public void gravar(Contato c){
//        contatos.add(c);
//    }
    
    @Override
    public void gravarFim(Contato c){
        contatos.addLast(c);
    }
    
    @Override
    public void gravarInicio(Contato c) {
        contatos.addFirst(c);
    }
    
    @Override
    public boolean remover(Contato c) {
        return contatos.remove(c);
    }
    
    @Override
    public Contato buscarByNome(String nome){
        for(Contato c : contatos){
            if(c.getNome().equals(nome))
                return c;
        }
        return null; 
    }
    @Override
    public Contato buscarByTelefone(String telefone){
        for (Contato c : contatos) {
            if (c.getTelefone().equals(telefone)) {
                return c;
            }
        }
        return null;
    }
    @Override
    public String listarComEnhancedFor() {
        int i = 1;
        String retorno = "";
        for (Contato c : contatos) {
            retorno += c.toString();
        }
        return retorno;
    }

    @Override
    public String listarComForEachClasseAnonima() {

        final StringBuilder retorno = new StringBuilder();

        contatos.forEach(new Consumer<Contato>() {
            @Override
            public void accept(Contato c) {
                retorno.append(c.toString());
            }
        });

        return retorno.toString();
    }

    @Override
    public String listarComForEachLambda() {
        final StringBuilder retorno = new StringBuilder();
        contatos.forEach(c -> retorno.append(c.toString()));
        return retorno.toString();
    }
    
    public String listarEmOrdemAlfabetica() {
        List<Contato> copia = new LinkedList<>(contatos);
        Collections.sort(copia);

        StringBuilder retorno = new StringBuilder();
        for (Contato c : copia) {
            retorno.append(c.toString());
        }
        return retorno.toString();
    }
}
