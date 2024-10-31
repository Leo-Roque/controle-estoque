package com.primestock.controle_estoque.controller;

import com.primestock.controle_estoque.model.Produto;
import com.primestock.controle_estoque.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> listarTodosProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Produto buscarProdutoPorId(@PathVariable Long id) {
        return produtoService.buscarProdutoPorId(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        return produtoService.criarProduto(produto);
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produto.setId(id);
        return produtoService.atualizarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
    }
}
