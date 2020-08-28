package interview.hellier.heroku.SpringREST.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.util.Date;

public class ApiException extends RuntimeException{

    public ApiException(String message) {
        super(message);

    }
}
