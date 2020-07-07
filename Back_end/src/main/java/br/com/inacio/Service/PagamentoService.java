package br.com.inacio.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inacio.Entidade.MetodoPagamento;
import br.com.inacio.Exception.DataIntegrityException;
import br.com.inacio.Exception.ExceptionSupplier;
import br.com.inacio.Repository.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repository;
	
	public List<MetodoPagamento> Lista(){
		return repository.findAll();
	}
	
	public MetodoPagamento Busca(Long id) {
		Optional<MetodoPagamento> opt = repository.findById(id);
		return opt.orElseThrow(() -> new ExceptionSupplier("Pagamento não realizado : id "+ id));
	}
	
	public MetodoPagamento Salvar(MetodoPagamento metodoPagamento) {
		return repository.save(metodoPagamento);
	}
	
	public MetodoPagamento Update(MetodoPagamento metodoPagamento) {
		return repository.save(metodoPagamento);
	}
	
	public void Deletar(Long id) {
		try {
			
			repository.deleteById(id);
		} catch (Exception e) {
			throw new DataIntegrityException("Erro ao deletar objeto vinculado a ele");
		}
	}
	
	

}
