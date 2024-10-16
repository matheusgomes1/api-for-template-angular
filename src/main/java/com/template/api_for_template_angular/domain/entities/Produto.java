package com.template.api_for_template_angular.domain.entities;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

import com.template.api_for_template_angular.domain.enums.SituacaoEnum;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;
    
    private String nome;
    
    private String descricao;
    
    private BigDecimal valor;
    
    private Date dataInclusao;

    @Enumerated(EnumType.ORDINAL)
    private SituacaoEnum situacao;

    @OneToMany(mappedBy = "produto")
    private List<Arquivo> arquivos;

    @ManyToMany(mappedBy = "produtos")  
    private List<Categoria> categorias;
}