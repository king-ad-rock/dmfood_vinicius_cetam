package br.com.cetam.dmfood.domain.cliente;

import br.com.cetam.dmfood.domain.endereco.DadosEndereco;

public record DadosCadastroCliente(
    String nome,
    String rg,
    String cpf,
    String email,
    String telefone,
    DadosEndereco endereco
) {

}
