package br.com.vendas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor
public class Produto {

    private Integer codigo;
    @JsonProperty("tipo_vinho")
    private String tipoVinho;
    private Double preco;
    private String safra;
    @JsonProperty("ano_compra")
    private int anoCompra;
}
