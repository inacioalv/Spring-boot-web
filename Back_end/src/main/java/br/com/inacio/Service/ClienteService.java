package br.com.inacio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inacio.Entidade.Cliente;
import br.com.inacio.Exception.ExceptionSupplier;
import br.com.inacio.Repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> Lista(){
		return repository.findAll();
	}
	
	public Cliente Busca(Long id) {
		Optional<Cliente> opt = repository.findById(id);
		return opt.orElseThrow(()-> new ExceptionSupplier("Cliente não encontrado: id "+id));
	}
	
	public Cliente Salvar (Cliente cliente) {
		return repository.save(cliente);
		
	}
	
	public Cliente update(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}

}
