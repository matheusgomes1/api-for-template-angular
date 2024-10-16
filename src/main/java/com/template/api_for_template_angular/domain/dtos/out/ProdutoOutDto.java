package com.template.api_for_template_angular.domain.dtos.out;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.template.api_for_template_angular.domain.entities.Produto;
import com.template.api_for_template_angular.domain.enums.SituacaoEnum;

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
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private SituacaoEnum situacao;

    public ProdutoOutDto(Produto produto) {
        this.produtoId = produto.getProdutoId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.valor = produto.getValor();
        this.dataInclusao = produto.getDataInclusao();
        this.situacao = produto.getSituacao();
    }
}
