package br.com.cetam.dmfood.domain.adm;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosUpdateAdm(
        @NotBlank
        String nome,

        @NotBlank @Email String email
        ) {
}
