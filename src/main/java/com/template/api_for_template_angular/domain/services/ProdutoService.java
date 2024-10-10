package com.template.api_for_template_angular.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.template.api_for_template_angular.domain.dtos.in.ProdutoFiltroDto;
import com.template.api_for_template_angular.domain.dtos.in.ProdutoInDto;
import com.template.api_for_template_angular.domain.dtos.out.ProdutoOutDto;
import com.template.api_for_template_angular.domain.entities.Arquivo;
import com.template.api_for_template_angular.domain.entities.Produto;
import com.template.api_for_template_angular.infra.repository.IArquivoJpaRepository;
import com.template.api_for_template_angular.infra.repository.IProdutoJpaRepository;

@Service
public class ProdutoService implements IProdutoService {
    @Autowired
    private IProdutoJpaRepository produtoJpaRepository;

    @Autowired
    private IArquivoJpaRepository arquivoJpaRepository;

    @Override
    public ProdutoOutDto obterPorId(Long id) {
        var produto = produtoJpaRepository.getReferenceById(id);

        return new ProdutoOutDto(produto.getProdutoId(), produto.getNome(), produto.getDescricao(), produto.getValor(), produto.getDataInclusao());
    }

    @Override
    public Page<ProdutoOutDto> listar(ProdutoFiltroDto dto) {
        var sort = Sort.by(dto.ordenadoPor == null || dto.ordenadoPor.isBlank() ? "produtoId" : dto.ordenadoPor);
        sort = (dto.decrescente != null && dto.decrescente == true) ? sort.descending() : sort.ascending();

        var pageRequest = PageRequest.of(dto.pagina, dto.tamanhoPagina, sort);
        

        return produtoJpaRepository.listar(dto, pageRequest);
    }

    @Override
    public ProdutoOutDto cadastrar(ProdutoInDto dto) {
        var produto = new Produto(null, dto.nome, dto.descricao, dto.valor, dto.dataInclusao, null, null);

        return new ProdutoOutDto(produtoJpaRepository.save(produto));
    }

    @Override
    public ProdutoOutDto atualizar(Long id, ProdutoInDto dto) {
        var produtoOpt = produtoJpaRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setNome(dto.nome);
            produto.setDescricao(dto.descricao);
            produto.setValor(dto.valor);
            produto.setDataInclusao(dto.dataInclusao);  // Caso queira alterar a data de inclusão também
            return new ProdutoOutDto(produtoJpaRepository.save(produto));  // Atualiza o produto
        } else {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }
    }

    @Override
    public void deletar(Long id) {
        if (produtoJpaRepository.existsById(id)) {
            var optProduto = produtoJpaRepository.findById(id);

            for (Arquivo arquivo : optProduto.get().getArquivos()) {
                arquivoJpaRepository.delete(arquivo);
            }

            produtoJpaRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Produto com ID " + id + " não encontrado.");
        }
    }
}
