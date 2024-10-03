package br.com.cetam.dmfood.domain.venda;

import br.com.cetam.dmfood.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity (name="Venda")
@Table(name="vendas")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantidade;
    private double valor;
    private double total;
    private LocalDate dataVenda;
    @ManyToOne
    @JoinColumn(name="produtoId")
    private Produto produto;

    public Venda(){}

    public Venda(DadosCadastroVenda dados){
        this.quantidade = dados.quantidade();
        this.valor = dados.valor();
        this.total = dados.total();
        this.dataVenda = dados.dataVenda();
    }
}
