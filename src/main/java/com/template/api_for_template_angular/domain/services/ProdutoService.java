package com.template.api_for_template_angular.domain.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.template.api_for_template_angular.domain.dtos.in.ProdutoFiltroDto;
import com.template.api_for_template_angular.domain.dtos.in.ProdutoInDto;
import com.template.api_for_template_angular.domain.dtos.out.ProdutoOutDto;
import com.template.api_for_template_angular.domain.entities.Produto;
import com.template.api_for_template_angular.infra.repository.IProdutoJpaRepository;

@Service
public class ProdutoService implements IProdutoService {
    @Autowired
    private IProdutoJpaRepository produtoJpaRepository;

    @Override
    public ProdutoOutDto obterPorId(Long id) {
        var produto = produtoJpaRepository.getReferenceById(id);

        return new ProdutoOutDto(produto.getProdutoId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getDataInclusao());
    }

    @Override
    public Page<ProdutoOutDto> listar(ProdutoFiltroDto dto) {
        var pageRequest = PageRequest.of(dto.pagina, dto.tamanhoPagina, 
            Sort.by(dto.ordenadoPor == null || dto.ordenadoPor.isBlank() ? "produtoId" : dto.ordenadoPor));

        return produtoJpaRepository.listar(dto, pageRequest);
    }

    @Override
    public void cadastrar(ProdutoInDto dto) {
        var produto = new Produto(null, dto.nome, dto.descricao, dto.valor, dto.dataInclusao);

        produtoJpaRepository.save(produto);
    }

    @Override
    public void atualizar(Long id, ProdutoInDto dto) {
        var produtoOpt = produtoJpaRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setNome(dto.nome);
            produto.setDescricao(dto.descricao);
            produto.setValor(dto.valor);
            produto.setDataInclusao(dto.dataInclusao);  // Caso queira alterar a data de inclusão também
            produtoJpaRepository.save(produto);  // Atualiza o produto
        } else {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }
    }

    @Override
    public void deletar(Long id) {
        if (produtoJpaRepository.existsById(id)) {
            produtoJpaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }
    }
}
