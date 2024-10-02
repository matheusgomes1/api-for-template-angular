package com.template.api_for_template_angular.domain.dtos.out;
import com.template.api_for_template_angular.domain.entities.Arquivo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ArquivoOutDto {
    public Long arquivoId;
    public String base64;
    public String mimeType;
    public String name;

    public ArquivoOutDto(Arquivo arquivo) {
        this.arquivoId = arquivo.getArquivoId();
        this.base64 = arquivo.getBase64();
        this.mimeType = arquivo.getMimeType();
        this.name = arquivo.getName();
    }
}
