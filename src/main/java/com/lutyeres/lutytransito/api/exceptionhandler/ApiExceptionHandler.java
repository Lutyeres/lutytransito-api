package com.lutyeres.lutytransito.api.exceptionhandler;

import com.lutyeres.lutytransito.domain.exception.NegocioExeception;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        

        return super.handleMethodArgumentNotValid(ex, headers, status, request);
    }

    // Metodo que captura a exececao e entrega um status correto com um body adequado
    @ExceptionHandler
    public ResponseEntity<String> capturar (NegocioExeception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
