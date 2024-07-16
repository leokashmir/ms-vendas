package br.com.vendas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Cliente {

    private String nome;
    private String cpf;
    List<Compra> compras;
}
