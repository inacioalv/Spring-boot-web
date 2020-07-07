package br.com.inacio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inacio.Entidade.MetodoPagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<MetodoPagamento, Long> {

}
