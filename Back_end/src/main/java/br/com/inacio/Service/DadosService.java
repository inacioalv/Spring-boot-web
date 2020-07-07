package br.com.inacio.Service;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import br.com.inacio.Entidade.DadosCliente;
import br.com.inacio.Exception.DataIntegrityException;
import br.com.inacio.Exception.ExceptionSupplier;
import br.com.inacio.Repository.DadosRepository;

@Service
public class DadosService {
	
	@Autowired
	private DadosRepository repository;
	
	
	public List<DadosCliente> Lista(){
		return repository.findAll();
	}
	
	public DadosCliente Busca(Long id) {
		Optional<DadosCliente> opt = repository.findById(id);
		return opt.orElseThrow(()-> new ExceptionSupplier("Dados não encontrado : id "+id));
	}
	
	public DadosCliente Salvar(DadosCliente obj) {
		obj.setDatanascimento(new Date());
		return repository.save(obj);
	}
	
	public DadosCliente Update (DadosCliente dadosCliente) {
		DadosCliente objUpdate= Busca(dadosCliente.getId());
		dadosCliente.setDatanascimento(objUpdate.getDatanascimento());
		return repository.save(dadosCliente);
	}
	
	public void Deletar(Long id) {
		try {
			
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Erro ao deletar objeto vinculado a ele");
		}
	}
}
