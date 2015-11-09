package br.com.mrcsfelipe.sbv.exceptions;

public class JDBCException extends Exception{
	
	private String mensagem = "Erro no Postgresql";
	
	@Override
	public String getMessage() {
		return mensagem;
	}
	
	public void setMessage(String mensagem){
		this.mensagem = mensagem;
	}

}
