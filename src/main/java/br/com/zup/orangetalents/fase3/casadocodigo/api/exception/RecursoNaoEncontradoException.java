package br.com.zup.orangetalents.fase3.casadocodigo.api.exception;

public class RecursoNaoEncontradoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static String msg = "Nao foi encontrado o recurso do tipo %s com id %d em nossa base";

	public RecursoNaoEncontradoException(String entidade, Long id) {
		super(String.format(msg, entidade , id));
	}

}
