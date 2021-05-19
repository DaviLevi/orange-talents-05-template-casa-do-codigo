package br.com.zup.orangetalents.fase3.casadocodigo.api.domain.validator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.com.zup.orangetalents.fase3.casadocodigo.api.contract.request.CadastroClienteRequest;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.Estado;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.estado.EstadoRepository;
import br.com.zup.orangetalents.fase3.casadocodigo.api.domain.pais.PaisRepository;

@Component
public class ProibeEstadoIdNuloOuInexistenteSePaisIdTiverFilhosValidator implements Validator{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return CadastroClienteRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(errors.hasErrors())
			return;
		
		CadastroClienteRequest request = (CadastroClienteRequest) target;
		
		Long paisId = request.getPaisId();
		Long estadoId = request.getEstadoId();
		
		Long quantidadeEstados = paisRepository.contarQuantosEstadosPeloId(paisId);
		
		// se o Pais mencionado tiver estados atrelados 
		// e o campo de estadoId não foi preenchido
		if(quantidadeEstados > 0 && estadoId == null) {
			errors.rejectValue("estadoId", null, "O campo estadoId tem que ser preenchido utilizando os estados disponíveis");
		}else 
		if(estadoId != null){
			Optional<Estado> estadoConsultado = estadoRepository.findById(estadoId);
			
			if(estadoConsultado.isEmpty())
				errors.rejectValue("estadoId", null, "Esse campo deve ter uma entidade associada");
		}
	}

}
