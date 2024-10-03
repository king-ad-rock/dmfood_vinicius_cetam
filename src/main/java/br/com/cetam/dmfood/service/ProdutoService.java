package br.com.cetam.dmfood.service;

import br.com.cetam.dmfood.domain.produto.DadosCadastroProduto;
import br.com.cetam.dmfood.domain.produto.DadosListaProduto;
import br.com.cetam.dmfood.domain.produto.DadosUpdateProduto;
import br.com.cetam.dmfood.domain.produto.Produto;
import br.com.cetam.dmfood.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(DadosCadastroProduto dados){
        Produto produto = new Produto(dados);
        return produtoRepository.save(produto);
    }

    public List<DadosListaProduto> listarProdutos(){
        return produtoRepository.findAll().stream()
                .map(DadosListaProduto::new)
                .collect(Collectors.toList());
    }

    public Optional<Produto> buscarProdutoPorId(Long id){ return produtoRepository.findById(id); }
    public Produto atualizarProduto(Long id, DadosUpdateProduto dados){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setNome(dados.nome());
        produto.setDescricao(dados.descricao());
        produto.setDescricao(dados.descricao());

        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id){ produtoRepository.deleteById(id); }
}
