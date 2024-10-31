package com.primestock.controle_estoque.controller;

import com.primestock.controle_estoque.dto.CategoriaDTO;
import com.primestock.controle_estoque.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<CategoriaDTO> listarTodasCategorias() {
        return categoriaService.listarTodasCategorias();
    }

    @GetMapping("/{id}")
    public CategoriaDTO buscarCategoriaPorId(@PathVariable Long id) {
        return categoriaService.buscarCategoriaPorId(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    @PostMapping
    public CategoriaDTO criarCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.criarCategoria(categoriaDTO);
    }

    @PutMapping("/{id}")
    public CategoriaDTO atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        return categoriaService.atualizarCategoria(id, categoriaDTO);
    }

    @DeleteMapping("/{id}")
    public void excluirCategoria(@PathVariable Long id) {
        categoriaService.excluirCategoria(id);
    }
}
