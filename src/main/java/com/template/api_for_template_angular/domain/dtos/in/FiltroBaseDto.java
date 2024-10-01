package com.template.api_for_template_angular.domain.dtos.in;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public abstract class FiltroBaseDto {
    @NotNull(message = "Campo Obrigatório")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Valor Inválido")
    public Integer pagina; 

    @NotNull(message = "Campo Obrigatório")
    @Digits(integer = Integer.MAX_VALUE, fraction = 0, message = "Valor Inválido")
    public Integer tamanhoPagina; 

    @NotNull(message = "Campo Obrigatório")
    public String ordenadoPor;

    @NotNull(message = "Campo Obrigatório")
    public Boolean decrescente;
}
