package br.com.inacio.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inacio.Entidade.Carrinho;
import br.com.inacio.Repository.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository repository;
	
	public List<Carrinho> Lista(){
		return repository.findAll();
	}
	
	public Carrinho Busca(Long id) {
		Optional<Carrinho> opt = repository.findById(id);
		return opt.orElse(null);
	}
	
	public Carrinho Salvar( Carrinho obj) {
		obj.setDatacompra(new Date());
		return repository.save(obj);
		}
	
	public Carrinho Update(Carrinho obj) {
		Carrinho objUpdate = Busca(obj.getId());
		objUpdate.setDatacompra(obj.getDatacompra());
		return repository.save(obj);
	}
	
	public void Deletar(Long id) {
		repository.deleteById(id);
	}
	
	

}
