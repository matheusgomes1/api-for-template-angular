package com.template.api_for_template_angular.domain.services;

import java.util.List;

import com.template.api_for_template_angular.domain.dtos.in.ArquivoInDto;
import com.template.api_for_template_angular.domain.dtos.out.ArquivoOutDto;

public interface IArquivoService {

    ArquivoOutDto cadastrar(ArquivoInDto dto);

    List<ArquivoOutDto> obterPorProdutoId(Long produtoId);

    Long deletar(Long id);
    
}