package br.com.inacio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inacio.Entidade.Endereco;
import br.com.inacio.Exception.DataIntegrityException;
import br.com.inacio.Exception.ExceptionSupplier;
import br.com.inacio.Repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repository;
	
	public List<Endereco> List(){
		return repository.findAll();
	}
	
	public Endereco Busca(Long id) {
		Optional<Endereco> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ExceptionSupplier("Endereço não encotrado : id " +id));
	}
	
	public Endereco Salvar(Endereco obj) {
		return repository.save(obj);
	}
	
	public Endereco update(Endereco obj) {
		return repository.save(obj);
	}
	
	public void Deletar(Long id) {
		try {
			
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Erro ao deletar objeto vinculado a ele");
		}
	}

}
