package br.com.cetam.dmfood.domain.venda;

import java.time.LocalDate;

public record DadosCadastroVenda(
        Long id,
        int quantidade,
        double valor,
        double total,
        LocalDate dataVenda) {
}
