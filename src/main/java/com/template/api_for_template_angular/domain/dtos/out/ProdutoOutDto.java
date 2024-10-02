package com.template.api_for_template_angular.domain.dtos.out;

import java.math.BigDecimal;
import java.util.Date;

import com.template.api_for_template_angular.domain.entities.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoOutDto {
    private Long produtoId;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private Date dataInclusao;

    public ProdutoOutDto(Produto produto) {
        this.produtoId = produto.getProdutoId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.dataInclusao = produto.getDataInclusao();
    }
}
