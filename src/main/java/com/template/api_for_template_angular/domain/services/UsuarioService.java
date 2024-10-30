package com.template.api_for_template_angular.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.template.api_for_template_angular.domain.dtos.in.CadastroUsuarioInDto;
import com.template.api_for_template_angular.domain.dtos.in.LoginInDto;
import com.template.api_for_template_angular.domain.dtos.out.LoginOutDto;
import com.template.api_for_template_angular.domain.entities.Usuario;
import com.template.api_for_template_angular.infra.repository.IUsuarioRepository;
import com.template.api_for_template_angular.infra.services.TokenService;

@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    IUsuarioRepository repository;
    
    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TokenService tokenService;

    @Override
    public Usuario cadastrar(CadastroUsuarioInDto cadastroDto) {
        var loginExistente = repository.findBylogin(cadastroDto.getLogin());

        if (loginExistente != null)
            throw new IllegalArgumentException("Login já existe");

        var emailExistente = repository.findByemail(cadastroDto.getEmail());

        if (emailExistente != null)
            throw new IllegalArgumentException("Email já existe");

        var usuario = new Usuario();
        usuario.setAtivo(true);
        usuario.setCodigoRecuperacao("");
        usuario.setNome(cadastroDto.getNome());
        usuario.setEmail(cadastroDto.getEmail());
        usuario.setLogin(cadastroDto.getLogin());
        usuario.setPermissao(cadastroDto.getPermissao());
        usuario.setSenha(passwordEncoder.encode(cadastroDto.getSenha()));

        repository.save(usuario);

        return usuario;
    }

    @Override
    public LoginOutDto login(LoginInDto loginDto) {
        var usuario = repository.findBylogin(loginDto.getLogin());

        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não encontrado");
        }

        if (!usuario.isAtivo()) {
            throw new IllegalArgumentException("Usuário inativo");
        }

        var authenticationToken = new UsernamePasswordAuthenticationToken(loginDto.getLogin(), loginDto.getSenha());
        var authentication = authenticationManager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return new LoginOutDto(tokenJWT);
    }
}
