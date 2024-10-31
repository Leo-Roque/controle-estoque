package com.primestock.controle_estoque.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProdutoDTO {

    private Long id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private BigDecimal preco;

    // O Lombok com @Data vai gerar automaticamente os getters, setters e outros métodos necessários
}
