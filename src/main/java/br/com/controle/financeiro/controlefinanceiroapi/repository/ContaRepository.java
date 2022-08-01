package br.com.controle.financeiro.controlefinanceiroapi.repository;

import br.com.controle.financeiro.controlefinanceiroapi.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Jonathas Baracho
 */
@Repository
@Transactional(readOnly = false)
public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Modifying
    @Query("update Conta c set c.saldo = c.saldo + ?1 where c.id = ?2")
    void setFixedSaldoFor(double valor, Long id);

    @Modifying
    @Query("update Conta c set c.saldo = c.saldo - ?1 where c.id = ?2")
    void setFixedSaldo(double valor, Long id);

    @Query("select c.saldo from Conta c where c.id = ?1")
    double getSaldoById(Long id);
}
