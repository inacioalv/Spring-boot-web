package br.com.inacio.Entidade;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.inacio.Enums.FormaPagamento;

@Entity
public class MetodoPagamento {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable
	private Set<Integer> forma = new HashSet<Integer>();
	
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<FormaPagamento> getForma() {
		return forma.stream().map(x -> FormaPagamento.toEnum(x)).collect(Collectors.toSet());
	}

	public void addforma(FormaPagamento formaPagamento) {
		forma.add(formaPagamento.getCodigo());
	}

	
	
	
	

}
