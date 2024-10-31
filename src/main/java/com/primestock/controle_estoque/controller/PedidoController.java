package com.primestock.controle_estoque.controller;

import com.primestock.controle_estoque.dto.PedidoDTO;
import com.primestock.controle_estoque.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoDTO> listarTodosPedidos() {
        return pedidoService.listarTodosPedidos();
    }

    @GetMapping("/{id}")
    public PedidoDTO buscarPedidoPorId(@PathVariable Long id) {
        return pedidoService.buscarPedidoPorId(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    @PostMapping
    public PedidoDTO criarPedido(@RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.criarPedido(pedidoDTO);
    }

    @PutMapping("/{id}")
    public PedidoDTO atualizarPedido(@PathVariable Long id, @RequestBody PedidoDTO pedidoDTO) {
        return pedidoService.atualizarPedido(id, pedidoDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirPedido(@PathVariable Long id) {
        pedidoService.excluirPedido(id);
    }
}
