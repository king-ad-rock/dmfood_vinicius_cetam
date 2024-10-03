package br.com.cetam.dmfood.repository;

import br.com.cetam.dmfood.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
