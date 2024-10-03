package br.com.cetam.dmfood.domain.produto;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name= "Produto")
@Table(name="produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private String categoria;

    public Produto() {}

    public Produto(DadosCadastroProduto dados) {
        this.nome = dados.nome();
        this.descricao = dados.descricao();
        this.categoria = dados.categoria();
    }
}
