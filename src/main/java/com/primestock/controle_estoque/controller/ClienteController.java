package com.primestock.controle_estoque.controller;

import com.primestock.controle_estoque.dto.ClienteDTO;
import com.primestock.controle_estoque.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDTO> listarTodosClientes() {
        return clienteService.listarTodosClientes();
    }

    @GetMapping("/{id}")
    public ClienteDTO buscarClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    @PostMapping
    public ClienteDTO criarCliente(@RequestBody ClienteDTO clienteDTO) {
        return clienteService.criarCliente(clienteDTO);
    }

    @PutMapping("/{id}")
    public ClienteDTO atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        return clienteService.atualizarCliente(id, clienteDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirCliente(@PathVariable Long id) {
        clienteService.excluirCliente(id);
    }
}
