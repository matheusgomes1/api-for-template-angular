package com.template.api_for_template_angular.domain.dtos.in;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ArquivoInDto {
    public Long arquivoId;
    public String base64;
    public String mimeType;
    public String name;
    public Long produtoId;
}
