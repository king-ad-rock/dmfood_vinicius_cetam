package br.com.cetam.dmfood.domain.adm;

import br.com.cetam.dmfood.domain.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="adm")
public class Adm extends Usuario {
    private String nomeAdm;
    private String email;

    public Adm(){
    }

    public Adm(DadosCadastroAdm dados) {
        this.nomeAdm = dados.nomeAdm();
        this.email = dados.emailAdm();
    }
}
