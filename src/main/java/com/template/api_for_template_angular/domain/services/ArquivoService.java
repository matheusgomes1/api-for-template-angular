package com.template.api_for_template_angular.domain.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.template.api_for_template_angular.domain.dtos.in.ArquivoInDto;
import com.template.api_for_template_angular.domain.dtos.out.ArquivoOutDto;
import com.template.api_for_template_angular.domain.entities.Arquivo;
import com.template.api_for_template_angular.infra.repository.IArquivoJpaRepository;
import com.template.api_for_template_angular.infra.repository.IProdutoJpaRepository;

@Service
public class ArquivoService implements IArquivoService {
    @Autowired
    private IProdutoJpaRepository produtoJpaRepository;
    
    @Autowired
    private IArquivoJpaRepository arquivoJpaRepository;

    @Override
    public ArquivoOutDto cadastrar(ArquivoInDto dto) {
        var produto = produtoJpaRepository.findById(dto.produtoId);

        if (!produto.isPresent()) {
            throw new IllegalArgumentException("Deve-se informar um produto válido");
        }

        var arquivo = new Arquivo(null, produto.get(), produto.get().getProdutoId(), dto.mimeType, dto.name, dto.base64);
        var arquivoSalvo = arquivoJpaRepository.save(arquivo);
        return new ArquivoOutDto(arquivoSalvo);
    }

    @Override
    public List<ArquivoOutDto> obterPorProdutoId(Long produtoId) {
        var arquivos = arquivoJpaRepository.findByProdutoId(produtoId);

        if (arquivos == null)
            return null;
        
        return arquivos.stream().map(ArquivoOutDto::new).collect(Collectors.toList());
    }

    @Override
    public Long deletar(Long id) {
        if (!arquivoJpaRepository.existsById(id))
            throw new IllegalArgumentException("Arquivo não encontrado na base");
        
        arquivoJpaRepository.deleteById(id);

        return id;
    }
}
