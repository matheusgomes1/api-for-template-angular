package com.template.api_for_template_angular.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long arquivoId;

    @ManyToOne
    @JoinColumn(name = "produtoId")
    private Produto produto;

    @Column(name = "produtoId", insertable = false, updatable = false)
    private Long produtoId;

    private String mimeType;
    private String name;

    @Column(name = "base64", columnDefinition="CLOB")
    private String base64;
}
