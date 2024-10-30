package com.template.api_for_template_angular.domain.dtos.in;

import com.template.api_for_template_angular.domain.enums.PermissaoEnum;

import lombok.Data;

@Data
public class CadastroUsuarioInDto {
    public String nome;
    public String email;
    public String login;
    public String senha;
    public PermissaoEnum permissao;
}
