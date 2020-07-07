package br.com.inacio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inacio.Entidade.Carrinho;

@Repository
public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
