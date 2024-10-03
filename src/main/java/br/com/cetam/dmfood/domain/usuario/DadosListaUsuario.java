package br.com.cetam.dmfood.domain.usuario;

import java.time.LocalDate;

public record DadosListaUsuario(
        Long id,
        String username,
        String password,
        String estadoLogin,
        LocalDate dataCadastro
) {
    public DadosListaUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getPassword(),
                usuario.getEstadoLogin(),
                usuario.getDataCadastro()
        );
    }
}


