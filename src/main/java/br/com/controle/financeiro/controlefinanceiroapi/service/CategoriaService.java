package br.com.controle.financeiro.controlefinanceiroapi.service;

import br.com.controle.financeiro.controlefinanceiroapi.model.Categoria;

import java.util.List;

/**
 * @author Jonathas Baracho
 */
public interface CategoriaService {

    Categoria salvarCategoria(Categoria categoria);
    List<Categoria> findAll();

}
