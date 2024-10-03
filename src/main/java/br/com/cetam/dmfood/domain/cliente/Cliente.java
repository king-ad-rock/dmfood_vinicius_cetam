package br.com.cetam.dmfood.domain.cliente;

import br.com.cetam.dmfood.domain.endereco.DadosEndereco;
import br.com.cetam.dmfood.domain.endereco.Endereco;
import br.com.cetam.dmfood.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Table(name = "cliente")
@Entity(name = "Cliente")
public class Cliente extends Usuario {


    private String nome;
    private String rg;
    private String cpf;
    private String email;
    private String telefone;

    private Boolean ativo;

    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(DadosCadastroCliente dados){
        this.ativo = true;
        this.cpf = dados.cpf();
        this.rg = dados.rg();
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }

}
