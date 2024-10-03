package br.com.cetam.dmfood.domain.produto;

import jakarta.validation.constraints.NotBlank;

public record DadosUpdateProduto(
        @NotBlank String nome,
        @NotBlank String descricao,
        @NotBlank String categoria
) {
}
