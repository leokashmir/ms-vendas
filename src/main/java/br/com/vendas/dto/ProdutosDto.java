package br.com.vendas.dto;

import br.com.vendas.model.Produto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
public class ProdutosDto {

    private List<Produto> produtoList;
}
