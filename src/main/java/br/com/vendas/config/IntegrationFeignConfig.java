package br.com.vendas.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;

import static br.com.vendas.enums.HeaderIntegration.ACCEPT;
import static br.com.vendas.enums.HeaderIntegration.CONSUMES;

public class IntegrationFeignConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(ACCEPT.getValue(), "application/json");
            requestTemplate.header(CONSUMES.getValue(), "application/json");
        };
    }
}
