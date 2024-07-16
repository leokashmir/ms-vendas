package br.com.vendas.controller;

import br.com.vendas.dto.CompraDetalhada;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Produto;
import br.com.vendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/compras")
    public ResponseEntity<List<CompraDetalhada>> getCompras() {

        return new ResponseEntity<List<CompraDetalhada>>(clienteService.getCompras(), HttpStatus.OK);
    }

    @GetMapping("/maior-compra/{ano}")
    public ResponseEntity<CompraDetalhada> getMaiorCompra(@PathVariable int ano) {
        return new ResponseEntity<CompraDetalhada>(clienteService.getMaiorCompraDoAno(ano),HttpStatus.OK);
    }

    @GetMapping("/clientes-fieis")
    public ResponseEntity<List<Cliente>> getClientesFieis() {

        return new ResponseEntity<List<Cliente>>(clienteService.getClientesFieis(), HttpStatus.OK);
    }

    @GetMapping("/recomendacao/cliente/{tipo}")
    public ResponseEntity<Produto> getRecomendacao(@RequestHeader(value = "document", required = false)  String cpf, @PathVariable String tipo) {
        return new ResponseEntity<Produto>(clienteService.getRecomendacaoPorTipo(cpf, tipo), HttpStatus.OK );
    }
}
