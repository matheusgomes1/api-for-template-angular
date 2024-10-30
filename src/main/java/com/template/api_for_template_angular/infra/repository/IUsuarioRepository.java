package com.template.api_for_template_angular.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.template.api_for_template_angular.domain.entities.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findBylogin(String login);

    Usuario findByemail(String email);
}
