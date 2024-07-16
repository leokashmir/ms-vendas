package br.com.vendas.dto;

import br.com.vendas.model.Cliente;
import br.com.vendas.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ClientesDto {

    private Cliente cliente;
    private List<Produto> produtoList;

}
