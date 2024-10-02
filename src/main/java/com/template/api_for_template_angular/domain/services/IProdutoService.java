package com.template.api_for_template_angular.domain.services;

import org.springframework.data.domain.Page;

import com.template.api_for_template_angular.domain.dtos.in.ProdutoFiltroDto;
import com.template.api_for_template_angular.domain.dtos.in.ProdutoInDto;
import com.template.api_for_template_angular.domain.dtos.out.ProdutoOutDto;

public interface IProdutoService {
    ProdutoOutDto obterPorId(Long id);

    Page<ProdutoOutDto> listar(ProdutoFiltroDto dto);

    ProdutoOutDto cadastrar(ProdutoInDto dto);

    ProdutoOutDto atualizar(Long id, ProdutoInDto dto);

    void deletar(Long id);
}