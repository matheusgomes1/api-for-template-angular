package com.template.api_for_template_angular.domain.dtos.in;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProdutoInDto {
    public Long produtoId;
    public String nome;
    public String descricao;
    public BigDecimal valor;
    public Date dataInclusao;
}
