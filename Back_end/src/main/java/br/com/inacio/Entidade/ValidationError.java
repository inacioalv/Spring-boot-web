package br.com.inacio.Entidade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandarErro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private  List<fieldMessage> erro = new ArrayList<fieldMessage>();
	
	public ValidationError() {}

	public ValidationError(Integer status, String msg) {
		super(status,msg);

	}

	public List<fieldMessage> getErro() {
		return erro;
	}

	public void addErro(String field, String message) {
		erro.add(new fieldMessage(field,message));
	}
	
	
	
	

}
