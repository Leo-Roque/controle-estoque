package com.primestock.controle_estoque.controller;

import com.primestock.controle_estoque.dto.FornecedorDTO;
import com.primestock.controle_estoque.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    @Autowired
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @GetMapping
    public List<FornecedorDTO> listarTodosFornecedores() {
        return fornecedorService.listarTodosFornecedores();
    }

    @GetMapping("/{id}")
    public FornecedorDTO buscarFornecedorPorId(@PathVariable Long id) {
        return fornecedorService.buscarFornecedorPorId(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    @PostMapping
    public FornecedorDTO criarFornecedor(@RequestBody FornecedorDTO fornecedorDTO) {
        return fornecedorService.criarFornecedor(fornecedorDTO);
    }

    @PutMapping("/{id}")
    public FornecedorDTO atualizarFornecedor(@PathVariable Long id, @RequestBody FornecedorDTO fornecedorDTO) {
        return fornecedorService.atualizarFornecedor(id, fornecedorDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirFornecedor(@PathVariable Long id) {
        fornecedorService.excluirFornecedor(id);
    }
}
