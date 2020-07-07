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

import br.com.inacio.Entidade.Endereco;
import br.com.inacio.Service.EnderecoService;

@RestController
@RequestMapping(value = "/Endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Endereco> List(){
		return service.List();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public Endereco Busca(@PathVariable Long id) {
		return service.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> Salvar(@Valid @RequestBody Endereco endereco){
		Endereco obj = service.Salvar(endereco);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update(@Valid @RequestBody Endereco endereco, @PathVariable Long id){
		endereco.setId(id);
		service.update(endereco);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> Deletar(@PathVariable Long id){
		service.Deletar(id);
		return ResponseEntity.noContent().build();
	}

}
