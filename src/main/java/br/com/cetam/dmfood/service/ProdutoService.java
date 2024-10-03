package br.com.cetam.dmfood.service;

import br.com.cetam.dmfood.domain.produto.DadosCadastroProduto;
import br.com.cetam.dmfood.domain.produto.Produto;
import br.com.cetam.dmfood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(DadosCadastroProduto dados){
        Produto produto = new Produto(dados);
        return produtoRepository.save(produto);
    }
}
