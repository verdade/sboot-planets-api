package br.com.planets.api.exception;

import br.com.planets.api.dto.response.ResponseErrorApiDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(value = {PlanetException.class})
    protected ResponseEntity<Object> handlePublisherPubSubException(final PlanetException ex, WebRequest request) {
        ResponseErrorApiDTO<Object> response = new ResponseErrorApiDTO<>();
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage("Erro interno no Servidor!");
        response.setContent(ex.getMessage());
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<?> handleNotFoundException(final Exception ex, WebRequest request) {
        ResponseErrorApiDTO<Object> response = new ResponseErrorApiDTO<>();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage("Nenhum registro encontrado!");
        response.setContent(ex.getMessage());
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }


    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseErrorApiDTO<Object> response = new ResponseErrorApiDTO<>();
        Map<String, String> fields = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            fields.put(error.getField(), error.getRejectedValue().toString());
        });
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Formato inválido para o(s) campo(s)!");
        response.setContent(fields.toString());
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ResponseErrorApiDTO<Object> response = new ResponseErrorApiDTO<>();
        Map<String, String> fields = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            fields.put(error.getField(), "Origatorio");
        });
        response.setCode(HttpStatus.BAD_REQUEST.value());
        response.setMessage("Formato inválido para o(s) campo(s)!");
        response.setContent(fields.toString());
        return handleExceptionInternal(ex, response, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }








}
