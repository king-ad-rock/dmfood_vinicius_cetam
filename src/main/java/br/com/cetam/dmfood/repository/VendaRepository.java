package br.com.cetam.dmfood.repository;

import br.com.cetam.dmfood.domain.venda.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
