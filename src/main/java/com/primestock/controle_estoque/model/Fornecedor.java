package com.primestock.controle_estoque.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String telefone;
    private String email;
    private String endereco;
}
