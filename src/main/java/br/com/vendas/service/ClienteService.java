package br.com.vendas.service;

import br.com.vendas.dto.CompraDetalhada;
import br.com.vendas.integration.ClienteClient;
import br.com.vendas.integration.ProdutoClient;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Produto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteClient clienteClint;
    private ProdutoClient produtoClient;

    List<Cliente> listCliente;
    List<Produto> listProdutos;

    public void getClienteAndProdutoLis(){
        listCliente =  clienteClint.getClientes();
        listProdutos = produtoClient.getProdutos();
    }

    public List<CompraDetalhada> getCompras() {
        this.getClienteAndProdutoLis();
        return listCliente.stream()
                .flatMap(cliente -> cliente.getCompras().stream()
                        .map(compra -> {
                            Produto produto = listProdutos.stream()
                                    .filter(p -> p.getCodigo().equals(compra.getCodigo()))
                                    .findFirst()
                                    .orElse(null);

                            double valorTotal = compra.getQuantidade() * (produto != null ? produto.getPreco() : 0);

                            return   CompraDetalhada.builder()
                                    .nomeCliente(cliente.getNome())
                                    .cpfCliente(cliente.getCpf())
                                    .produto(produto)
                                    .quantidade(compra.getQuantidade())
                                    .valorTotal(valorTotal)
                                    .build();
                        }))
                .sorted(Comparator.comparingDouble(CompraDetalhada::getValorTotal))
                .collect(Collectors.toList());

    }
    public CompraDetalhada getMaiorCompraDoAno(int ano) {
        this.getClienteAndProdutoLis();

        return listCliente.stream()
                .flatMap(cliente -> cliente.getCompras().stream()
                        .map(compra -> {
                            Produto produto = listProdutos.stream()
                                    .filter(p -> p.getCodigo().equals(compra.getCodigo()) && p.getAnoCompra() == ano)
                                    .findFirst()
                                    .orElse(null);

                            double valorTotal = compra.getQuantidade() * (produto != null ? produto.getPreco() : 0);

                            return   CompraDetalhada.builder()
                                    .nomeCliente(cliente.getNome())
                                    .cpfCliente(cliente.getCpf())
                                    .produto(produto)
                                    .quantidade(compra.getQuantidade())
                                    .valorTotal(valorTotal)
                                    .build();
                        }))
                .max(Comparator.comparingDouble(CompraDetalhada::getValorTotal))
                .orElse(null);
    }

    public List<Cliente> getClientesFieis() {
        this.getClienteAndProdutoLis();
        return listCliente.stream()
                .sorted((c1, c2) -> Double.compare(
                        c2.getCompras().stream()
                                .mapToDouble(compra -> {
                                    Produto produto = listProdutos.stream()
                                            .filter(p -> p.getCodigo().equals(compra.getCodigo()))
                                            .findFirst()
                                            .orElse(null);
                                    return produto != null ? compra.getQuantidade() * produto.getPreco() : 0;
                                })
                                .sum(),
                        c1.getCompras().stream()
                                .mapToDouble(compra -> {
                                    Produto produto = listProdutos.stream()
                                            .filter(p -> p.getCodigo().equals(compra.getCodigo()))
                                            .findFirst()
                                            .orElse(null);
                                    return produto != null ? compra.getQuantidade() * produto.getPreco() : 0;
                                })
                                .sum()))
                .limit(3)
                .collect(Collectors.toList());
    }


    public Produto getRecomendacaoPorTipo(String cpf, String tipo) {
        this.getClienteAndProdutoLis();
        Cliente cliente = listCliente.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);

        if (cliente != null) {
            Map<String, Long> tipoVinhoCount = cliente.getCompras().stream()
                    .map(compra -> listProdutos.stream()
                            .filter(p -> p.getCodigo().equals(compra.getCodigo()))
                            .findFirst()
                            .orElse(null))
                    .filter(Objects::nonNull)
                    .collect(Collectors.groupingBy(Produto::getTipoVinho, Collectors.counting()));

            String tipoMaisComprado = tipoVinhoCount.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(tipo);

            return listProdutos.stream()
                    .filter(p -> p.getTipoVinho().equals(tipoMaisComprado))
                    .findFirst()
                    .orElse(null);
        }

        return null;

    }
}
