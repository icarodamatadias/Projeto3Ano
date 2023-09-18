package com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.http.HttpHeaders;


import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.exceptions.BadRequestException;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.exceptions.BadRequestExceptionDetails;
import com.linguagemDeProgramacao.Projeto3Ano.backEndSistema.exceptions.ValidationExceptionDatails;

import java.util.List;

import java.time.LocalDateTime;
import java.util.stream.Collectors;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{

        @ExceptionHandler(BadRequestException.class)
        public ResponseEntity<BadRequestExceptionDetails> handleBadRequestException(BadRequestException bre){
                return new ResponseEntity<>(
                        BadRequestExceptionDetails.builder()
                                .timestamp(LocalDateTime.now())
                                .status(HttpStatus.BAD_REQUEST.value())
                                .title("Bad Request Exception, Check the Documentation")
                                .details(bre.getMessage())
                                .developerMessage(bre.getClass().getName())
                                .build(), HttpStatus.BAD_REQUEST);
        }

        @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
        MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(
                ValidationExceptionDatails.builder()
                        .timestamp(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST.value())
                        .title("Bad Request Exception, Invalid fields")
                        .details("Check the field(s) error")
                        .developerMessage(exception.getClass().getName())
                        .fields(fields)
                        .fieldsMessage(fieldsMessage)
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
