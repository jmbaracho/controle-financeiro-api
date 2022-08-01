package br.com.controle.financeiro.controlefinanceiroapi.repository;

import br.com.controle.financeiro.controlefinanceiroapi.model.Movimentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Jonathas Baracho
 */
@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
}
