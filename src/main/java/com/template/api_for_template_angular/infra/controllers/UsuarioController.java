package com.template.api_for_template_angular.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.template.api_for_template_angular.domain.dtos.in.CadastroUsuarioInDto;
import com.template.api_for_template_angular.domain.services.IUsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping("/cadastro")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid CadastroUsuarioInDto cadastroUsuarioDto, UriComponentsBuilder uriBuilder) {

        var usuario = usuarioService.cadastrar(cadastroUsuarioDto);

        return ResponseEntity.ok(usuario);
    }
}
