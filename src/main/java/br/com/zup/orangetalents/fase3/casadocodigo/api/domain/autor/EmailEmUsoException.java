package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor;

public class EmailEmUsoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String mensagem = "Ja existe um cadastro com email '%s' em nossa base";
	
	public EmailEmUsoException(String email) {
		super(String.format(mensagem, email));
	}
	
	
}
