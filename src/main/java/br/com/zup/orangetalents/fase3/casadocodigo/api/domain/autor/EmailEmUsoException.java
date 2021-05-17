package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor;

public class EmailEmUsoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private static String msg = "Email %s já em uso em nosso sistema. Por favor, utilize um outro valor.";
	
	
	public EmailEmUsoException(String email) {
		super(String.format(msg, email));
	}
	
}
