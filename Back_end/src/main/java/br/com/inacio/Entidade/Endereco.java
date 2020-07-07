package br.com.inacio.Entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class Endereco implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "Informe a rua")
	private String rua;
	@NotBlank(message = "Informe o número")
	private String numero;
	@NotBlank(message = "Informe o CEP")
	@Length(min = 8, max = 8, message = "O CEP deve ter 8 caracteres")
	private String cep;
	@NotBlank(message = "Informe a cidade")
	@Length(max = 80, min = 10, message = "O nome da cidade deve ter entre 10 a 80 caracteres")
	private String cidade;
	
	@OneToMany(mappedBy = "endereco", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Carrinho> listacarrinho= new ArrayList<Carrinho>();
	
	public Endereco() {}
	
	public Endereco(Long id, String rua, String numero, String cep, String cidade) {
		super();
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Carrinho> getListacarrinho() {
		return listacarrinho;
	}

	public void setListacarrinho(List<Carrinho> listacarrinho) {
		this.listacarrinho = listacarrinho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rua == null) ? 0 : rua.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}

	
	
	
	
	
	
	
	

}
