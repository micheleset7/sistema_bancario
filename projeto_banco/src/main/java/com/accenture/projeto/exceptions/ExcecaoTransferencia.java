package com.accenture.projeto.exceptions;

public class ExcecaoTransferencia extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getMessage() {
		//3 - Enter a message in it and return the same
		    System.out.println("Passou por aqui");
		    
			return "Pegou mensagem";
	}

	@Override
	public String toString() {
		return "CustomException [getMessage()=" + getMessage() + "]";
	}
}
