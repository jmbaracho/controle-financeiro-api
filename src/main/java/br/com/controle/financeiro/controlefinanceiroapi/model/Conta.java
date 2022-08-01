package br.com.controle.financeiro.controlefinanceiroapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Jonathas Baracho
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Conta implements Serializable {
    @ApiModelProperty(value = "Código da conta")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_conta")
    private Long id;

    private String descricao;
    private double saldo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Conta conta = (Conta) o;
        return id != null && Objects.equals(id, conta.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void creditar(double valor) {
        saldo += valor;
    }

    public void debitar(double valor) {
        saldo -= valor;
    }
}
