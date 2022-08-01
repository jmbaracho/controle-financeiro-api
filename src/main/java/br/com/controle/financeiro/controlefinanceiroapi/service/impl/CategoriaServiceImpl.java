package br.com.controle.financeiro.controlefinanceiroapi.service.impl;

import br.com.controle.financeiro.controlefinanceiroapi.model.Categoria;
import br.com.controle.financeiro.controlefinanceiroapi.repository.CategoriaRepository;
import br.com.controle.financeiro.controlefinanceiroapi.service.CategoriaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jonathas Baracho
 */

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria salvarCategoria(Categoria categoria) {
        try {
            categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar categoria.");
        }
        return categoria;
    }

    @Override
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
