package br.com.cetam.dmfood.repository;

import br.com.cetam.dmfood.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
