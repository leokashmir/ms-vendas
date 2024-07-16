package br.com.vendas.dto;

import br.com.vendas.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder @Getter @Setter
public class CompraDetalhada {

    private String nomeCliente;
    private String cpfCliente;
    private Produto produto;
    private int quantidade;
    private Double valorTotal;
}
