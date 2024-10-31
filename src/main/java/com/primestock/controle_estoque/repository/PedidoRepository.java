package com.primestock.controle_estoque.repository;

import com.primestock.controle_estoque.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Métodos de consulta adicionais podem ser adicionados aqui, se necessário
}
