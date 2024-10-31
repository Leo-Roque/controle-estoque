package com.primestock.controle_estoque.dto;

import lombok.Data;

@Data
public class FornecedorDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
}
