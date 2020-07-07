package br.com.inacio.Resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.inacio.Entidade.Cliente;
import br.com.inacio.Service.ClienteService;

@RestController
@RequestMapping(value = "/Cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Cliente> Lista(){
		return service.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Cliente BuscaID(@PathVariable Long id){
		return service.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar (@Valid @RequestBody Cliente cliente){
		Cliente obj = service.Salvar(cliente);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update(@RequestBody Cliente cliente,@PathVariable Long id){
		cliente.setId(id);
		service.update(cliente);
		return ResponseEntity.noContent().build();
		
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
