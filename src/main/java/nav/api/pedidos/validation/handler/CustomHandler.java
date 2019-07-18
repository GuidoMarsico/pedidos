package nav.api.pedidos.validation.handler;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*** 
 * Clase custom para manejar errores o devolver mensajes de validaciones
 * ***/
@ControllerAdvice
public class CustomHandler extends ResponseEntityExceptionHandler {
	
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("estado", status.value());

        //Obtengo todo los errores
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errores", errors);

        return new ResponseEntity<>(body, headers, status);

    }
	
	/*** Para manejar excepciones que llegaran a no catchear ***/
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handlerServerError(Exception ex) {
		
		 Map<String, Object> body = new LinkedHashMap<>();
	     body.put("estado", HttpStatus.INTERNAL_SERVER_ERROR);
	     
	     List<String> errors = Arrays.asList("Error en el servidor!");
	     
		 body.put("errores", errors);
		
		 return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
