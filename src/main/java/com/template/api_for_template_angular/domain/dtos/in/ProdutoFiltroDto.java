package com.template.api_for_template_angular.domain.dtos.in;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoFiltroDto extends FiltroBaseDto {
    public String nome;
    public String descricao;
    public BigDecimal valor;
    public Date dataInicial;
    public Date dataFinal;
}
