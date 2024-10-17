package com.template.api_for_template_angular.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.template.api_for_template_angular.domain.dtos.in.CategoriaFiltroDto;
import com.template.api_for_template_angular.domain.dtos.out.CategoriaOutDto;
import com.template.api_for_template_angular.domain.entities.Categoria;
import com.template.api_for_template_angular.domain.specifications.CategoriaSpecification;
import com.template.api_for_template_angular.infra.repository.ICategoriaJpaRepository;

@Service
public class CategoriaService implements ICategoriaService {
    @Autowired
    private ICategoriaJpaRepository categoriaJpaRepository; 

    @Override
    public Page<CategoriaOutDto> listar(CategoriaFiltroDto dto) {
        var sort = Sort.by(dto.ordenadoPor == null || dto.ordenadoPor.isBlank() ? "nome" : dto.ordenadoPor);
        sort = (dto.decrescente != null && dto.decrescente == true) ? sort.descending() : sort.ascending();

        var pageRequest = PageRequest.of(dto.pagina, dto.tamanhoPagina, sort);

        CategoriaSpecification specification = new CategoriaSpecification(dto);

        Page<Categoria> categorias = categoriaJpaRepository.findAll(specification, pageRequest);

        return categorias.map(categoria -> new CategoriaOutDto(categoria.getCategoriaId(), categoria.getNome()));
    }
}
