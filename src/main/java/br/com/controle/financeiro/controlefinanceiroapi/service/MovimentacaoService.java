package br.com.controle.financeiro.controlefinanceiroapi.service;

import br.com.controle.financeiro.controlefinanceiroapi.model.Movimentacao;

import java.util.List;

/**
 * @author Jonathas Baracho
 */
public interface MovimentacaoService {

    Movimentacao salvarMovimentacao(Movimentacao movimentacao);
    List<Movimentacao> findAll();

}
