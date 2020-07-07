package br.com.inacio.Enums;



public enum FormaPagamento {
	
		CARTAO(1,"ROLE_CARTAO"),
		BOLETO(2,"ROLE_BOLETO");

		
	
		private FormaPagamento(int codigo, String descrcao) {
			this.codigo = codigo;
			this.descrcao = descrcao;
		}
		
		private int codigo;
		private String descrcao;
		
		public int getCodigo() {
			return codigo;
		}
		public void setCodigo(int codigo) {
			this.codigo = codigo;
		}
		public String getDescrcao() {
			return descrcao;
		}
		public void setDescrcao(String descrcao) {
			this.descrcao = descrcao;
		}
		
		
		
		public static FormaPagamento toEnum(Integer codigo) {
			if(codigo == null) {
				return null;
			}
			for(FormaPagamento o : FormaPagamento.values()){
				if(codigo.equals(o.getCodigo())) {
					return o;
				}
			}
			
			throw new IllegalArgumentException("Código inválido: " + codigo);
		}
		
	
	
}
