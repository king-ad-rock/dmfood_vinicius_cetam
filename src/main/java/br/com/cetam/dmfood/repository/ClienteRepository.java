package br.com.cetam.dmfood.repository;

import br.com.cetam.dmfood.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
