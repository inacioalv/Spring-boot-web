package br.com.inacio.Resource;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.inacio.Entidade.Carrinho;
import br.com.inacio.Service.CarrinhoService;

@RestController
@RequestMapping(value = "/Carrinho")
public class CarrinhoResource {
	
	@Autowired
	private CarrinhoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Carrinho> Lista(){
		return service.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Carrinho Busca(@PathVariable Long id) {
		return service.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar( @RequestBody Carrinho carrinho){
		Carrinho obj = service.Salvar(carrinho);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update( @RequestBody Carrinho obj, @PathVariable Long id){
		obj.setId(id);
		service.Update(obj);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		service.Deletar(id);
		return ResponseEntity.noContent().build();
	}

}
