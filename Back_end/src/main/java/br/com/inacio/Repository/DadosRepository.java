package br.com.inacio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inacio.Entidade.DadosCliente;


@Repository
public interface DadosRepository extends JpaRepository<DadosCliente, Long> {

}
