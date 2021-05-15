package br.com.zup.orangetalents.fase3.casadocodigo.api.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.error.Erro;
import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.error.Erro.PropriedadeInvalida;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.autor.EmailEmUsoException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
			
		List<PropriedadeInvalida> propriedadesInvalidas = ex.getAllErrors().stream().map(oe -> {
			String propriedade = oe.getObjectName();
			String descricao = messageSource.getMessage(oe, LocaleContextHolder.getLocale());
			if (oe instanceof FieldError) {
				propriedade = ((FieldError)oe).getField();
			}
			return new PropriedadeInvalida(propriedade, descricao);
		}).collect(Collectors.toList());
		
		Erro erro = new Erro(status.value(), "Dados inválidos", 
				"Corpo da requisição inválido. Por favor, verifique o conteudo e envie novamente",
				propriedadesInvalidas);
		
		return ResponseEntity.badRequest().body(erro);
	}
	
	@ExceptionHandler(EmailEmUsoException.class)
	protected ResponseEntity<Object> handleEmailEmUsoException(EmailEmUsoException ex, WebRequest request) {
			
		Erro erro = new Erro(HttpStatus.CONFLICT.value(), 
				"Conflito", ex.getMessage());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
}
