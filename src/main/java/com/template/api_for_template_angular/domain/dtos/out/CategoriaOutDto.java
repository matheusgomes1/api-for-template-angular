package com.template.api_for_template_angular.domain.dtos.out;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CategoriaOutDto {
    private Long categoriaId;
    private String nome;
}
