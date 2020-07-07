package br.com.inacio.Resource;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



import br.com.inacio.Entidade.StandarErro;
import br.com.inacio.Entidade.ValidationError;
import br.com.inacio.Exception.DataIntegrityException;
import br.com.inacio.Exception.ExceptionSupplier;


@ControllerAdvice
public class ResourceExceptionHandler {

	// interceptador
	
	// NOT_FOUND(404, "Not Found") erro ao encontrar o objeto
	@ExceptionHandler(ExceptionSupplier.class)
	public ResponseEntity<StandarErro>objectNotFound(ExceptionSupplier e, HttpServletRequest request){
		StandarErro err = new StandarErro(HttpStatus.NOT_FOUND.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	// BAD_REQUEST(400, "Bad Request") erro ao deletar objeto vinculadas
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandarErro>DataIntegrityException(DataIntegrityException e, HttpServletRequest request){
		StandarErro err = new StandarErro(HttpStatus.BAD_REQUEST.value(),e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandarErro> ValidException(MethodArgumentNotValidException e, HttpServletRequest request){
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de validação");
		for(FieldError o : e.getBindingResult().getFieldErrors()) {
			err.addErro(o.getField(), o.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
}
