package br.com.cetam.dmfood.domain.cliente;

import br.com.cetam.dmfood.domain.endereco.DadosEndereco;
import br.com.cetam.dmfood.domain.endereco.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosUpdateCliente(
        @NotBlank
        @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")
        String cpf,

        @NotBlank @Pattern(regexp = "\\d{7}\\-\\d{1}")
        String rg,

        @NotBlank
        String nome,

        @NotBlank @Email
        String email,

        @NotBlank
        String telefone,

        @NotNull @Valid
        DadosEndereco endereco
) {
}
