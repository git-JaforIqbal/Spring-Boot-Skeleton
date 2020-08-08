package com.project.citysite.callcentermgm.customerror;


import com.project.citysite.callcentermgm.entity.ExceptionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

	public static final String ERR_DATA_VALIDATION_CODE = "ERR_2012";
	public static final String TIME_STAMP = new SimpleDateFormat("dd.MM.yyyy HH.mm.ss").format(new Date());
    private static String LOG_FILE_NAME = "error_response";
    public static final String RESPONSE_TECHNICAL_TEAM = "Please contact to the technical support";

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(ex.getLocalizedMessage(), status);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request, HttpHeaders headers, HttpStatus status) throws Exception {

    	Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", this.TIME_STAMP);
        body.put("code", this.ERR_DATA_VALIDATION_CODE);
        body.put("status", HttpStatus.BAD_REQUEST);

        //Get all errors
        String errors = ex.getMessage().toString();
               

        body.put("data", errors);

        return new ResponseEntity<>(body, headers, status);
    }

    // @Validate For Validating Path Variables and Request Parameters
    @ExceptionHandler(ConstraintViolationException.class)
    public void constraintViolationException(HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", this.TIME_STAMP);
        body.put("code", this.ERR_DATA_VALIDATION_CODE);
        body.put("status", HttpStatus.BAD_REQUEST);

        //Get all errors
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("data", errors);

        return new ResponseEntity<>(body, headers, status);

    }
    
    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
      NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
    	
    	Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", this.TIME_STAMP);
        body.put("code", this.ERR_DATA_VALIDATION_CODE);
        body.put("status", HttpStatus.BAD_REQUEST);

        //Get all errors
        String errors = ex.getMessage().toString();
               

        body.put("data", errors);

        return new ResponseEntity<>(body, headers, status);
    	
    }
    
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
      HttpRequestMethodNotSupportedException ex, 
      HttpHeaders headers, 
      HttpStatus status, 
      WebRequest request) {
    	
    	Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", this.TIME_STAMP);
        body.put("code", this.ERR_DATA_VALIDATION_CODE);
        body.put("status", HttpStatus.BAD_REQUEST);

        //Get all errors
        String errors = ex.getMessage().toString();
               

        body.put("data", errors);

        return new ResponseEntity<>(body, headers, status);
    }

}
