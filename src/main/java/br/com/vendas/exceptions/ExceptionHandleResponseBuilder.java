package br.com.vendas.exceptions;

import org.springframework.stereotype.Component;

@Component
public class ExceptionHandleResponseBuilder {

    public ExceptionHandleResponse getExceptionHandleResponse(Integer httpCode, String message){
        return ExceptionHandleResponse.builder()
              .error(ErrorHandle.builder()
                        .httpCode(httpCode.toString())
                        .message(message)
                        .build())
                .build();
    }
}
