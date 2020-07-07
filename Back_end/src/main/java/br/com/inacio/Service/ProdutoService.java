package br.com.inacio.Service;

import java.util.Date;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;



import br.com.inacio.Entidade.Produtos;
import br.com.inacio.Exception.DataIntegrityException;
import br.com.inacio.Exception.ExceptionSupplier;
import br.com.inacio.Repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	

	
	public Page<Produtos>Lista(Integer page, Integer size,String direction, String orderBy){
		PageRequest pagerequest = PageRequest.of(page, size, Direction.valueOf(direction), orderBy);
		return repository.findAll(pagerequest);
	}
	
	public Produtos Busca(Long id) {
		Optional<Produtos> opt = repository.findById(id);
		return opt.orElseThrow(()-> new ExceptionSupplier("Produto não encontrado : id"+ id));
	}
	
	
	public Produtos save(Produtos obj){
		obj.setData(new Date());
		return repository.save(obj);
	}
	
	public Produtos Update(Produtos produto) {
		Produtos objUpdate= Busca(produto.getId());
		produto.setData(objUpdate.getData());
		return repository.save(produto);
	}
	
	
	public void Deletar(Long id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
				throw new DataIntegrityException("Erro ao deletar objeto vinculado a ele");
		}
		
	}

}
