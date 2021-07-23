package com.dio.controleponto.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Calendario {

    @Id
    private Long id;
    @ManyToOne
    private TipoData tipo;
    private String descricao;
    private LocalDateTime dataEspecial;
}
