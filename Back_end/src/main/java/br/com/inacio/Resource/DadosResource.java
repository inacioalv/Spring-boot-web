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

import br.com.inacio.Entidade.DadosCliente;
import br.com.inacio.Service.DadosService;

@RestController
@RequestMapping(value = "/DadosCliente")
public class DadosResource {
	
	@Autowired
	private DadosService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DadosCliente> Lista(){
		return service.Lista();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "{id}")
	public DadosCliente Busca(@PathVariable Long id) {
		return service.Busca(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody DadosCliente cliente){
		DadosCliente obj = service.Salvar(cliente);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "{id}")
	public ResponseEntity<Void> Update(@Valid @RequestBody DadosCliente cliente,@PathVariable Long id){
		cliente.setId(id);
		service.Update(cliente);
		return ResponseEntity.noContent().build();
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.Deletar(id);
		return ResponseEntity.noContent().build();
	}
	

}
