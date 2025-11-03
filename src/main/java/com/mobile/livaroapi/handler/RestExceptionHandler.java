package com.mobile.livaroapi.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Map<String, String> handleGenericException(Exception ex) {

        Map<String, String> response = new HashMap<>();
        response.put("error", "Erro Interno do Servidor.");
        response.put("message", "Ocorreu um erro inesperado. Tente novamente mais tarde.");

        response.put("dev_detail", ex.getMessage());

        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, Object> handleValidationExceptions(MethodArgumentNotValidException e) {
        // 1. Coleta os erros de campo
        Map<String, String> fieldErrors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            fieldErrors.put(fieldName, errorMessage);
        });

        // 2. Monta o objeto de resposta final
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", "Erro de Validação. Verifique os campos.");
        // Retorna o mapa limpo para fácil consumo
        response.put("details", fieldErrors);

        return response;
    }

    /**
     * Trata a exceção de Regra de Negócio (ex: E-mail duplicado)
     */
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleIllegalStateException(IllegalStateException e) {
        // Retorna a mensagem customizada do Service com status 400
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
