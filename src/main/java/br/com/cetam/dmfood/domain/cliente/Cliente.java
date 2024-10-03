package br.com.cetam.dmfood.domain.cliente;

import br.com.cetam.dmfood.domain.endereco.Endereco;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded // indica no banco de dados que essa classe Endereco faz parte da mesma tabela de Paciente
    private Endereco endereco;

    private Boolean ativo;

    public Cliente() {}

    public Cliente(DadosCadastroCliente dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
        this.ativo = true;
    }
}
