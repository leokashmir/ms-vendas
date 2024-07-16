package br.com.vendas.integration;

import br.com.vendas.config.IntegrationFeignConfig;
import br.com.vendas.model.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "clientClint", url = "${integration.host}", configuration = IntegrationFeignConfig.class)
public interface ClienteClient {

    @GetMapping(value = "${integration.clientes.url}")
    List<Cliente> getClientes();

}
