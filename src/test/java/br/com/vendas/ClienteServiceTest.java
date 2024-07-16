package br.com.vendas;

import br.com.vendas.dto.CompraDetalhada;
import br.com.vendas.integration.ClienteClient;
import br.com.vendas.integration.ProdutoClient;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Compra;
import br.com.vendas.model.Produto;
import br.com.vendas.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @Mock
    private ClienteClient clienteClient;

    @Mock
    private ProdutoClient produtoClient;

    @InjectMocks
    private ClienteService clienteService;



    private List<Cliente> clientes;
    private List<Produto> produtos;

    @BeforeEach
    public void setUp() {
        produtos = Arrays.asList(
                new Produto(1, "Tinto", 229.99, "2017", 2018),
                new Produto(2, "Branco", 126.50, "2018", 2019)
        );

        clientes = Arrays.asList(
                new Cliente("Geraldo Pedro Julio Nascimento", "05870189179", Arrays.asList(
                        new Compra(1, 6),
                        new Compra(15, 4),
                        new Compra(10, 2),
                        new Compra(5, 3),
                        new Compra(2, 5)
                )),
                new Cliente("Vitória Alícia Mendes", "20623850567", Arrays.asList(
                        new Compra(1, 8)
                )),
                new Cliente("Teresinha Daniela Galvão", "04372012950", Arrays.asList(
                        new Compra(14, 3),
                        new Compra(20, 3),
                        new Compra(4, 2)
                ))
        );

        when(clienteClient.getClientes()).thenReturn(clientes);
        when(produtoClient.getProdutos()).thenReturn(produtos);
    }

    @Test
    public void testGetCompras() {
        List<CompraDetalhada> compras = clienteService.getCompras();
        assertNotNull(compras);
        assertEquals(9, compras.size());
    }

    @Test
    public void testGetMaiorCompraDoAno() {
        CompraDetalhada maiorCompra = clienteService.getMaiorCompraDoAno(2018);
        assertNotNull(maiorCompra);
        assertEquals("Vitória Alícia Mendes", maiorCompra.getNomeCliente());
    }

    @Test
    public void testGetClientesFieis() {
        List<Cliente> clientesFieis = clienteService.getClientesFieis();
        assertNotNull(clientesFieis);
        assertEquals(3, clientesFieis.size());
    }

    @Test
    public void testGetRecomendacaoPorTipo() {
        Produto recomendacao = clienteService.getRecomendacaoPorTipo("05870189179", "Tinto");
        assertNotNull(recomendacao);
        assertEquals("Tinto", recomendacao.getTipoVinho());
    }
}