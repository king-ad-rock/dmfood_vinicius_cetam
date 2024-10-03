package br.com.cetam.dmfood.controller;

import br.com.cetam.dmfood.domain.usuario.DadosListaUsuario;
import br.com.cetam.dmfood.domain.usuario.DadosUsuarioCadastro;
import br.com.cetam.dmfood.domain.usuario.Usuario;
import br.com.cetam.dmfood.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ibc/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody DadosUsuarioCadastro dados) {
        Usuario novoUsuario = usuarioService.cadastrarUsuario(dados);
        return new  ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DadosListaUsuario>> listarUsuarios() {
        List<DadosListaUsuario> usuarios = usuarioService.listarUsuarios();
        return ResponseEntity.ok(usuarios);
    }
}
