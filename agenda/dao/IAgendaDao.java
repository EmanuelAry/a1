/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package agendaprova.dao;

/**
 *
 * @author emanuelary
 */

import agendaprova.model.Contato;

public interface IAgendaDao {

    void gravarFim(Contato c);

    void gravarInicio(Contato c);

    boolean remover(Contato c);

    Contato buscarByNome(String nome);

    Contato buscarByTelefone(String telefone);

    String listarComEnhancedFor();

    String listarComForEachClasseAnonima();

    String listarComForEachLambda();
}
