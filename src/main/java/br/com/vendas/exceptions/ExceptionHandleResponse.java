package br.com.vendas.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Builder @Setter @Getter
public class ExceptionHandleResponse {

    @JsonProperty("error")
    private ErrorHandle error;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
