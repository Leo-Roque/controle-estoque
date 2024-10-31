package com.primestock.controle_estoque.repository;

import com.primestock.controle_estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Métodos de consulta adicionais podem ser adicionados aqui se necessário
}
