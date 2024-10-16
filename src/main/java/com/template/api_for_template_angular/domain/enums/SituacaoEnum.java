package com.template.api_for_template_angular.domain.enums;

public enum SituacaoEnum {
    ATIVO("ativo"),
    INATIVO("inativo"),
    PENDENTE("pendente");

    private final String descricao;

    SituacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }
}
