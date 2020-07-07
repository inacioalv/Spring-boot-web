package br.com.inacio.Resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import br.com.inacio.Entidade.Produtos;
import br.com.inacio.Service.ProdutoService;


@RestController
@RequestMapping(value = "/Produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	

	//Buscar por paginas
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<Produtos>>  Lista(
			@RequestParam(value = "page" ,defaultValue="0") Integer page, 
			@RequestParam(value = "size", defaultValue = "24") Integer size,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction,
			@RequestParam(value = "orderBy", defaultValue = "nome" ) String orderBy){
		Page<Produtos> pageOBJ = service.Lista(page,size,direction,orderBy);
		return ResponseEntity.ok().body(pageOBJ);
	}
	
	
	@RequestMapping(method = RequestMethod.GET,value = "/{id}")
	public Produtos busca(@PathVariable Long id) {
		return service.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	
	public ResponseEntity<Void>save(@Valid @RequestBody Produtos produto){
		Produtos obj= service.save(produto);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update(@RequestBody Produtos produto,@PathVariable Long id){
		 produto.setId(id);	
		 service.Update(produto);
		 return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.Deletar(id);
		return ResponseEntity.noContent().build();
	}

}
