package br.com.inacio.Entidade;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class Carrinho implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/mm/yyyy")
	private Date datacompra;
	
	
	private int prestacao;
	
	@ManyToOne
	private Endereco endereco;
	
	@ManyToOne
	private MetodoPagamento metodoPagamento;
	
	@ManyToOne
	private DadosCliente cliente;
	
	@ManyToOne
	private Produtos produtos;
	
	public Carrinho(){}
	
	
	public Carrinho(Long id, Date datacompra, int prestacao) {
		super();
		this.id = id;
		this.datacompra = datacompra;
		this.prestacao = prestacao;
		
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPrestacao() {
		return prestacao;
	}

	public void setPrestacao(int prestacao) {
		this.prestacao = prestacao;
	}
	
	

	public Date getDatacompra() {
		return datacompra;
	}

	public void setDatacompra(Date datacompra) {
		this.datacompra = datacompra;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	


	public MetodoPagamento getMetodoPagamento() {
		return metodoPagamento;
	}


	public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	

	public DadosCliente getCliente() {
		return cliente;
	}


	public void setCliente(DadosCliente cliente) {
		this.cliente = cliente;
	}


	public Produtos getProdutos() {
		return produtos;
	}


	public void setProdutos(Produtos produtos) {
		this.produtos = produtos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((datacompra == null) ? 0 : datacompra.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + prestacao;
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
		Carrinho other = (Carrinho) obj;
		if (datacompra == null) {
			if (other.datacompra != null)
				return false;
		} else if (!datacompra.equals(other.datacompra))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (prestacao != other.prestacao)
			return false;
		return true;
	}

	
	
	
	
	
	

}
