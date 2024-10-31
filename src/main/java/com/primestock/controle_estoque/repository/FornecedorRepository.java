package com.primestock.controle_estoque.repository;

import com.primestock.controle_estoque.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    // Métodos de consulta adicionais podem ser adicionados aqui, se necessário
}
