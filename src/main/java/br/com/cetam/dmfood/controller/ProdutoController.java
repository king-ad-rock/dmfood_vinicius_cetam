package br.com.cetam.dmfood.controller;

import br.com.cetam.dmfood.domain.produto.DadosCadastroProduto;
import br.com.cetam.dmfood.domain.produto.DadosListaProduto;
import br.com.cetam.dmfood.domain.produto.DadosUpdateProduto;
import br.com.cetam.dmfood.domain.produto.Produto;
//import br.com.cetam.dmfood.domain.usuario.DadosUsuarioCadastro;
import br.com.cetam.dmfood.domain.usuario.Usuario;
import br.com.cetam.dmfood.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ibc/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody DadosCadastroProduto dados) {
        Produto novoProduto = produtoService.cadastrarProduto(dados);
        return new  ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DadosListaProduto>> listarProdutos() {
        List<DadosListaProduto> produtos = produtoService.listarProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.buscarProdutoPorId(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody DadosUpdateProduto dadosAtualizados) {
        Produto produto = produtoService.atualizarProduto(id, dadosAtualizados);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}
