package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.livro;

import br.com.zup.orangetalents.fase3.casadocodigo.api.exception.RecursoNaoEncontradoException;

public class LivroNaoEncontradoException extends RecursoNaoEncontradoException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String NOME_RECURSO = "livro";
	
	public LivroNaoEncontradoException(Long id) {
		super(NOME_RECURSO, id);
	}

	
	
	
	
}
