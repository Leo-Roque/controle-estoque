package com.primestock.controle_estoque.repository;

import com.primestock.controle_estoque.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Métodos adicionais de consulta podem ser adicionados aqui, se necessário
}
