package com.template.api_for_template_angular.domain.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.template.api_for_template_angular.domain.dtos.in.ProdutoFiltroDto;
import com.template.api_for_template_angular.domain.entities.Produto;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ProdutoSpecification implements Specification<Produto> {

    private ProdutoFiltroDto filtro;

    public ProdutoSpecification(ProdutoFiltroDto filtro) {
        this.filtro = filtro;
    }

    @Override
    public Predicate toPredicate(Root<Produto> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate predicate = criteriaBuilder.conjunction();

        if (filtro.getNome() != null && !filtro.getNome().isEmpty()) {
            predicate = criteriaBuilder.and(predicate, 
                criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + filtro.getNome().toLowerCase() + "%"));
        }

        if (filtro.getDescricao() != null && !filtro.getDescricao().isEmpty()) {
            predicate = criteriaBuilder.and(predicate, 
                criteriaBuilder.like(criteriaBuilder.lower(root.get("descricao")), "%" + filtro.getDescricao().toLowerCase() + "%"));
        }

        if (filtro.getValor() != null) {
            predicate = criteriaBuilder.and(predicate, 
                criteriaBuilder.equal(root.get("valor"), filtro.getValor()));
        }

        if (filtro.getDataInicial() != null && filtro.getDataFinal() != null) {
            predicate = criteriaBuilder.and(predicate, 
                criteriaBuilder.between(root.get("dataInclusao"), filtro.getDataInicial(), filtro.getDataFinal()));
        }

        return predicate;
    }
}
