package com.template.api_for_template_angular.infra.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.template.api_for_template_angular.domain.dtos.in.ProdutoFiltroDto;
import com.template.api_for_template_angular.domain.dtos.out.ProdutoOutDto;
import com.template.api_for_template_angular.domain.entities.Produto;

@Repository 
public interface IProdutoJpaRepository extends JpaRepository<Produto, Long> {
    
    static final String PARAMETROS = " WHERE 1=1 "; // TODO: usar Criteria API para filtros

    @Query(value = "SELECT new com.template.api_for_template_angular.domain.dtos.out.ProdutoOutDto(p.produtoId, p.nome, p.descricao, p.valor, p.dataInclusao) " +
                "FROM Produto p " +
                PARAMETROS
        , countQuery = "SELECT COUNT(*) FROM Produto p " + PARAMETROS)
    public Page<ProdutoOutDto> listar(@Param("filtro") ProdutoFiltroDto filtro, Pageable pageable);
}
