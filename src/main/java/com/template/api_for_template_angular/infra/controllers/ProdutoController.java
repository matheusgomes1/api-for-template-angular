package com.template.api_for_template_angular.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.api_for_template_angular.domain.dtos.in.ProdutoFiltroDto;
import com.template.api_for_template_angular.domain.dtos.in.ProdutoInDto;
import com.template.api_for_template_angular.domain.dtos.out.ProdutoOutDto;
import com.template.api_for_template_angular.domain.services.IProdutoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    @Autowired
    IProdutoService produtoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Boolean> cadastrar(@RequestBody ProdutoInDto dto) {
        produtoService.cadastrar(dto);
        
        return ResponseEntity.ok(true);
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<ProdutoOutDto> obterPorId(@PathVariable Long id) {
        var produtoDto = produtoService.obterPorId(id);

        return ResponseEntity.ok(produtoDto);
    }
    
    
    @GetMapping("/listar")
    public ResponseEntity<Page<ProdutoOutDto>> listar(ProdutoFiltroDto filtro) {
        var listar = produtoService.listar(filtro);

        return ResponseEntity.ok(listar);
    }  

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Boolean> atualizar(@PathVariable Long id, @RequestBody ProdutoInDto dto) {
        produtoService.atualizar(id, dto);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/error500")
    public ResponseEntity<String> generateInternalServerError() {
        throw new RuntimeException("Custom error message: This is a simulated 500 Internal Server Error");
    }

    @GetMapping("/error400")
    public ResponseEntity<String> generateBadRequestError() {
        return ResponseEntity.badRequest().body("Custom error message: This is a simulated 400 Bad Request");
    }
}
