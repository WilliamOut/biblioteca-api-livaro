package com.mobile.livaroapi.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.mobile.livaroapi.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Object> handleJsonErrors(HttpMessageNotReadableException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String path = request.getDescription(false).replace("uri=","");
        String detailMessage = "Corpo da requisição inválido!Confira a sintaxe JSON!";
        if(detailMessage != null) {
            detailMessage = ex.getRootCause().getMessage();
        }
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                status.value(),
                status.getReasonPhrase(),
                detailMessage,
                path,
                null
        );
        return new ResponseEntity<>(errorResponseDTO,status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex,WebRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        String path = request.getDescription(false).replace("uri=","");
        String detailMessage = "Erro em um ou mais campos!";
        if(ex.getCause() != null) {
            detailMessage = ex.getCause().getMessage();
        }
        List<String> listError = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> e.getField() + ": " + e.getDefaultMessage())
                .collect(Collectors.toList());
        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                status.value(),
                status.getReasonPhrase(),
                detailMessage,
                path,
                listError
        );
        return new ResponseEntity<>(errorResponseDTO,status);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorResponseDTO> handleIllegalStateException(IllegalStateException ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        String detailMessage = ex.getMessage();
        String path = request.getDescription(false).replace("uri=", "");

        ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO(
                status.value(),
                "Regra de Negócio Violada",
                detailMessage,
                path,
                null
        );

        return new ResponseEntity<>(errorResponseDTO, status);
    }
}
