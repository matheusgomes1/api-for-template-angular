package com.template.api_for_template_angular.infra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.api_for_template_angular.domain.dtos.in.LoginInDto;
import com.template.api_for_template_angular.domain.dtos.out.LoginOutDto;

@RestController
@RequestMapping("login")
public class LoginController {

    @PostMapping()
    public ResponseEntity<LoginOutDto> login(@RequestBody LoginInDto dto) {
        
        var loginout = new LoginOutDto("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6IjEyMzQ1Njc4OTAiLCJub21lIjoiTWF0aGV1cyBHb21lcyIsImZvdG8iOiJodHRwczovL2p3dC5pby9pbWcvcGljX2xvZ28uc3ZnIiwiaWF0IjoxNTE2MjM5MDIyfQ.jcd7zX1JDdtifgeqRG44aTJ8t2F3bC-5Bx8hpsk1uaw");
        
        return ResponseEntity.ok(loginout);
    }
}
