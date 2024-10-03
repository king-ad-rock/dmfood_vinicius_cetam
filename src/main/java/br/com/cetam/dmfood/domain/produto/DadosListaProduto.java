package br.com.cetam.dmfood.domain.produto;

public record DadosListaProduto(
        Long id,
        String nome,
        String descricao,
        String categoria
) {
    public DadosListaProduto(Produto produto) {
        this(
                produto.getId(), produto.getNome(), produto.getDescricao(), produto.getCategoria()
        );
    }
}
