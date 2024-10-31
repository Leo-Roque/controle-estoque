package com.primestock.controle_estoque.repository;

import com.primestock.controle_estoque.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Métodos de consulta adicionais podem ser adicionados aqui, se necessário
}
