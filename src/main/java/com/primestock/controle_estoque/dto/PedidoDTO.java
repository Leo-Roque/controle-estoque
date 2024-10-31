package com.primestock.controle_estoque.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PedidoDTO {

    private Long id;
    private Long clienteId;
    private Long produtoId;
    private Integer quantidade;
    private LocalDate data;
}
