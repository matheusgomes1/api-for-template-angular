package com.template.api_for_template_angular.infra.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.api_for_template_angular.domain.dtos.in.LoginInDto;
import com.template.api_for_template_angular.domain.dtos.out.LoginOutDto;
import com.template.api_for_template_angular.domain.services.IUsuarioService;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping()
    public ResponseEntity<LoginOutDto> login(@RequestBody LoginInDto dto) {
        
        var loginOut = this.usuarioService.login(dto);

        return ResponseEntity.ok(loginOut);
    }
}
