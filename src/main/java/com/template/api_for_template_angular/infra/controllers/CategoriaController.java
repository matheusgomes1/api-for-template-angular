package com.template.api_for_template_angular.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.api_for_template_angular.domain.dtos.in.CategoriaFiltroDto;
import com.template.api_for_template_angular.domain.dtos.out.CategoriaOutDto;
import com.template.api_for_template_angular.domain.services.ICategoriaService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("categoria")
public class CategoriaController {
    @Autowired
    ICategoriaService categoriaService;
    
    @GetMapping("/listar")
    public ResponseEntity<Page<CategoriaOutDto>> listar(CategoriaFiltroDto filtro) {
        var listar = categoriaService.listar(filtro);

        return ResponseEntity.ok(listar);
    }  
}
