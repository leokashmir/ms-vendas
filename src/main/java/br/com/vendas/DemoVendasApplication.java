package br.com.vendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoVendasApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoVendasApplication.class, args);
	}

}
