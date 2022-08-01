package br.com.controle.financeiro.controlefinanceiroapi.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Jonathas Baracho
 */

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Categoria implements Serializable {
    @ApiModelProperty(value = "Código da categoria")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria")
    private Long id;

    @ApiModelProperty(value = "Descrição da categoria")
    @Column(nullable = false)
    private String descricao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Categoria categoria = (Categoria) o;
        return id != null && Objects.equals(id, categoria.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
