package br.com.controle.financeiro.controlefinanceiroapi.service.impl;

import br.com.controle.financeiro.controlefinanceiroapi.model.Movimentacao;
import br.com.controle.financeiro.controlefinanceiroapi.model.TipoMovimentacao;
import br.com.controle.financeiro.controlefinanceiroapi.repository.MovimentacaoRepository;
import br.com.controle.financeiro.controlefinanceiroapi.service.ContaService;
import br.com.controle.financeiro.controlefinanceiroapi.service.MovimentacaoService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Jonathas Baracho
 */
@Service
public class MovimentacaoServiceImpl implements MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    private final ContaService contaService;

    public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository,
                                   ContaService contaService) {
        this.movimentacaoRepository = movimentacaoRepository;
        this.contaService = contaService;
    }

    @Override
    public Movimentacao salvarMovimentacao(Movimentacao movimentacao) {
        try {
            if (movimentacao.getTipoMovimentacao().toString().equals("RECEITA")) {
                contaService.creditar(movimentacao.getValor(), movimentacao.getConta().getId());
            } else {
                contaService.debitar(movimentacao.getValor(), movimentacao.getConta().getId());
            }
            movimentacaoRepository.save(movimentacao);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar movimentacao.");
        }
        return movimentacao;
    }

    @Override
    public List<Movimentacao> findAll() {
        return movimentacaoRepository.findAll();
    }
}
