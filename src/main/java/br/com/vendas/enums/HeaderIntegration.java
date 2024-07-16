package br.com.vendas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum HeaderIntegration {

    ACCEPT("Accept"),
    CONSUMES("consumes");

    final String value;
}
