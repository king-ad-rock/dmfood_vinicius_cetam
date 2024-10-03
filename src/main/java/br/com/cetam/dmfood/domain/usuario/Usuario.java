package br.com.cetam.dmfood.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String estadoLogin;
    private LocalDate dataCadastro;

//    public Usuario() {}

//    public Usuario(DadosUsuarioCadastro dados){
//        this.username = dados.username();
//        this.password = dados.password();
//        this.estadoLogin = dados.estadoLogin();
//        this.dataCadastro = dados.dataCadastro();
//    }
}
