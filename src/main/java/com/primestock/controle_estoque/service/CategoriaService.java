package com.primestock.controle_estoque.service;

import com.primestock.controle_estoque.dto.CategoriaDTO;
import com.primestock.controle_estoque.model.Categoria;
import com.primestock.controle_estoque.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<CategoriaDTO> listarTodasCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<CategoriaDTO> buscarCategoriaPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(this::convertToDTO);
    }

    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = convertToEntity(categoriaDTO);
        return convertToDTO(categoriaRepository.save(categoria));
    }

    public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = convertToEntity(categoriaDTO);
        categoria.setId(id);
        return convertToDTO(categoriaRepository.save(categoria));
    }

    public void excluirCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Métodos auxiliares para conversão
    private CategoriaDTO convertToDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(categoria.getId());
        dto.setNome(categoria.getNome());
        dto.setDescricao(categoria.getDescricao());
        return dto;
    }

    private Categoria convertToEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        return categoria;
    }
}
