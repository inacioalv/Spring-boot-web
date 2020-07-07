package br.com.inacio.Entidade;

public class StandarErro {
	
	private Integer Status;
	private String msg;
	
	public StandarErro() {}
	
	public StandarErro(Integer status, String msg) {
		super();
		Status = status;
		this.msg = msg;
	}
	
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	
	
}
