package br.com.vendas.integration;

import br.com.vendas.config.IntegrationFeignConfig;
import br.com.vendas.dto.ProdutosDto;
import br.com.vendas.model.Produto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "produtoClient", url = "${integration.host}",  configuration = IntegrationFeignConfig.class)
public interface ProdutoClient {

    @GetMapping(value = "${integration.produtos.url}")
    List<Produto> getProdutos();
}
