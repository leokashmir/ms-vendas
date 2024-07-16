# # Micro Service ms-vendas


## Tecnologias

- Java JDK 22     -> https://www.oracle.com/java/technologies/javase/jdk22-archive-downloads.html
- Maven           -> https://maven.apache.org/
- SpringBoot      -> https://spring.io/projects/spring-boot

## Executar o Projeto
Pode-se executar o projeto direto em sua IDE.


## API - Curl


 * GET: /compras - Retornar uma lista das compras ordenadas de forma crescente por valor, deve conter o nome dos clientes, cpf dos clientes, dado dos produtos, quantidade das compras e valores totais de cada compra.
```http
curl --location 'localhost:8080/app/v1/compras'
```

* GET: /maior-compra/{ano} - (Exemplo: /maior_compra/2016) - Retornar a maior compra do ano informando os dados da compra disponibilizados, deve ter o nome do cliente, cpf do cliente, dado do produto, quantidade da compra e seu valor total.
```http
curl --location 'localhost:8080/app/v1/maior-compra/2018'
```

* GET: /clientes-fieis - Retornar o Top 3 clientes mais fieis, clientes que possuem mais compras recorrentes com maiores valores.
```http
curl --location 'localhost:8080/app/v1/clientes-fieis'
```

* GET: /recomendacao/cliente/{tipo} - Retornar uma recomendação de vinho baseado nos tipos de vinho que o cliente mais compra.
```http
curl --location 'localhost:8080/app/v1/recomendacao/cliente/Tinto' \
--header 'document: 20623850567'
```


## Author


[@leokashmir](https://www.github.com/leokashmir)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/leokashmir/)
