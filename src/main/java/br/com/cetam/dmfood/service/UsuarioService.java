package br.com.cetam.dmfood.service;

import br.com.cetam.dmfood.domain.usuario.DadosListaUsuario;
import br.com.cetam.dmfood.domain.usuario.DadosUsuarioCadastro;
import br.com.cetam.dmfood.domain.usuario.Usuario;
import br.com.cetam.dmfood.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(DadosUsuarioCadastro dados) {
        Usuario usuario = new Usuario(dados);
        return usuarioRepository.save(usuario);
    }


    public List<DadosListaUsuario> listarUsuarios() {
    }
}
