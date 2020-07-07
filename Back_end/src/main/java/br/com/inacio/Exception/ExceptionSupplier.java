package br.com.inacio.Exception;

public class ExceptionSupplier extends RuntimeException {

	
	private static final long serialVersionUID = 1L;
	
	public ExceptionSupplier(String msg) {
		super(msg);
	}
	
	public ExceptionSupplier(String msg,Throwable causa) {
		super(msg,causa);
	}

}
