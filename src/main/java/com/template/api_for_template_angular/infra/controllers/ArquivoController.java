package com.template.api_for_template_angular.infra.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.template.api_for_template_angular.domain.dtos.in.ArquivoInDto;
import com.template.api_for_template_angular.domain.dtos.out.ArquivoOutDto;
import com.template.api_for_template_angular.domain.services.IArquivoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("arquivo")
public class ArquivoController {
    
    @Autowired
    private IArquivoService arquivoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ArquivoOutDto> cadastrar(@RequestBody ArquivoInDto dto) {
        var retorno = arquivoService.cadastrar(dto);
        
        return ResponseEntity.ok(retorno);
    }

    @GetMapping("/obterPorProduto/{produtoId}")
    public ResponseEntity<List<ArquivoOutDto>> obterPorId(@PathVariable("produtoId") Long produtoId) {
        var retorno = arquivoService.obterPorProdutoId(produtoId);

        return ResponseEntity.ok(retorno);
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Long> deletar(@PathVariable("id") Long id) {
        var retorno = arquivoService.deletar(id);
        return ResponseEntity.ok(retorno);
    }
}
