package com.dio.controleponto.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Calendario {
    private Long id;
    private TipoData tipo;
    private String descricao;
    private LocalDateTime dataEspecial;
}
