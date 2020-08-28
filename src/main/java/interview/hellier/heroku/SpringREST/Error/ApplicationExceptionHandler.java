package interview.hellier.heroku.SpringREST.Error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleFileNotFoundException(FileNotFoundException exception, WebRequest webRequest) {
        Error error = new Error(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(error, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException exception, WebRequest webRequest) {
        Error error = new Error(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception exception, WebRequest webRequest) {
        Error error = new Error(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(URISyntaxException.class)
    public ResponseEntity<?> handleURISyntaxException(URISyntaxException exception, WebRequest webRequest) {
        Error error = new Error(new Date(), exception.getMessage(), webRequest.getDescription(false));

        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }







}
