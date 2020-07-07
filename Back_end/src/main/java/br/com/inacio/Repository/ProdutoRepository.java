package br.com.inacio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inacio.Entidade.Produtos;

@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {

}
