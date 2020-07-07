package br.com.inacio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.inacio.Entidade.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
