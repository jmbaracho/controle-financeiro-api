package br.com.controle.financeiro.controlefinanceiroapi.service;

import br.com.controle.financeiro.controlefinanceiroapi.model.Conta;
import br.com.controle.financeiro.controlefinanceiroapi.model.TipoMovimentacao;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jonathas Baracho
 */

public interface ContaService {

    Conta salvarConta(Conta conta);
    List<Conta> findAll();
    void creditar(double valor, Long id);
    void debitar(double valor, Long id);
}
