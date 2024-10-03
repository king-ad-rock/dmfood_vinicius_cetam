package br.com.cetam.dmfood.controller;

import br.com.cetam.dmfood.domain.produto.DadosCadastroProduto;
import br.com.cetam.dmfood.domain.produto.Produto;
import br.com.cetam.dmfood.domain.usuario.DadosUsuarioCadastro;
import br.com.cetam.dmfood.domain.usuario.Usuario;
import br.com.cetam.dmfood.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
