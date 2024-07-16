package br.com.vendas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Compra {

    private Integer codigo;
    private Integer quantidade;
}
