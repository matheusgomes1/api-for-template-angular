package com.template.api_for_template_angular.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.template.api_for_template_angular.domain.entities.Arquivo;
import java.util.List;


@Repository 
public interface IArquivoJpaRepository extends JpaRepository<Arquivo, Long> {
    
    List<Arquivo> findByProdutoId(Long produtoId);
}
