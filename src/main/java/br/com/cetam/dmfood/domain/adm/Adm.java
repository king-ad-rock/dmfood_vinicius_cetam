package br.com.cetam.dmfood.domain.adm;

import br.com.cetam.dmfood.domain.usuario.Usuario;
import lombok.Data;

@Data
public class Adm extends Usuario {
    private String nomeAdm;
    private String email;
}
