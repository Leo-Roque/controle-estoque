package com.primestock.controle_estoque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

// Anotação para definir a classe como uma entidade JPA e mapear para a tabela 'produto'
@Entity
@Table(name = "produto")
public class Produto {

    // Atributos da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private Integer quantidade;
    private BigDecimal preco;

    // Construtor sem parâmetros (necessário para o JPA)
    public Produto() {}

    // Construtor completo, útil para inicializações específicas
    public Produto(String nome, String categoria, Integer quantidade, BigDecimal preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    // Getters e Setters para encapsulamento
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Integer getQuantidade() { return quantidade; }
    public void setQuantidade(Integer quantidade) { this.quantidade = quantidade; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}
