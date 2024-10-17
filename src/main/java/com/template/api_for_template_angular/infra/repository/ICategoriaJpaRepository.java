package com.template.api_for_template_angular.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.template.api_for_template_angular.domain.entities.Categoria;

@Repository 
public interface ICategoriaJpaRepository extends JpaRepository<Categoria, Long>, JpaSpecificationExecutor<Categoria> {
}
