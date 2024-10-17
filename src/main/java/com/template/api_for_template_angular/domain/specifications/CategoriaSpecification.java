package com.template.api_for_template_angular.domain.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.template.api_for_template_angular.domain.dtos.in.CategoriaFiltroDto;
import com.template.api_for_template_angular.domain.entities.Categoria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class CategoriaSpecification implements Specification<Categoria> {

    private CategoriaFiltroDto filtro;

    public CategoriaSpecification(CategoriaFiltroDto filtro) {
        this.filtro = filtro;
    }

    @Override
    public Predicate toPredicate(Root<Categoria> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        predicate = criteriaBuilder.and(predicate, 
            criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));

        return predicate;
    }
}
