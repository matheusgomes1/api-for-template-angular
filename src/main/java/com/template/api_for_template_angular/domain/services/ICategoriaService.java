package com.template.api_for_template_angular.domain.services;

import org.springframework.data.domain.Page;

import com.template.api_for_template_angular.domain.dtos.in.CategoriaFiltroDto;
import com.template.api_for_template_angular.domain.dtos.out.CategoriaOutDto;

public interface ICategoriaService {

    Page<CategoriaOutDto> listar(CategoriaFiltroDto dto);

}