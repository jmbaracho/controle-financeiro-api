package br.com.controle.financeiro.controlefinanceiroapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Jonathas Baracho
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Movimentacao implements Serializable {
    @ApiModelProperty(value = "Código da movimentação")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_movimentacao")
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @OneToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @OneToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;

    private double valor;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate data;
    private String comentario;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movimentacao that = (Movimentacao) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
