package com.template.api_for_template_angular.domain.services;

import com.template.api_for_template_angular.domain.dtos.in.CadastroUsuarioInDto;
import com.template.api_for_template_angular.domain.dtos.in.LoginInDto;
import com.template.api_for_template_angular.domain.dtos.out.LoginOutDto;
import com.template.api_for_template_angular.domain.entities.Usuario;

public interface IUsuarioService {

    Usuario cadastrar(CadastroUsuarioInDto cadastroDto);

    LoginOutDto login(LoginInDto loginDto);

}