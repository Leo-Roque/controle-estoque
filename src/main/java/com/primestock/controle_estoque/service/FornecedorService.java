package com.primestock.controle_estoque.service;

import com.primestock.controle_estoque.dto.FornecedorDTO;
import com.primestock.controle_estoque.model.Fornecedor;
import com.primestock.controle_estoque.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    @Autowired
    public FornecedorService(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    public List<FornecedorDTO> listarTodosFornecedores() {
        return fornecedorRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<FornecedorDTO> buscarFornecedorPorId(Long id) {
        return fornecedorRepository.findById(id)
                .map(this::convertToDTO);
    }

    public FornecedorDTO criarFornecedor(FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = convertToEntity(fornecedorDTO);
        return convertToDTO(fornecedorRepository.save(fornecedor));
    }

    public FornecedorDTO atualizarFornecedor(Long id, FornecedorDTO fornecedorDTO) {
        Fornecedor fornecedor = convertToEntity(fornecedorDTO);
        fornecedor.setId(id);
        return convertToDTO(fornecedorRepository.save(fornecedor));
    }

    public void excluirFornecedor(Long id) {
        fornecedorRepository.deleteById(id);
    }

    // Métodos auxiliares para conversão
    private FornecedorDTO convertToDTO(Fornecedor fornecedor) {
        FornecedorDTO dto = new FornecedorDTO();
        dto.setId(fornecedor.getId());
        dto.setNome(fornecedor.getNome());
        dto.setTelefone(fornecedor.getTelefone());
        dto.setEmail(fornecedor.getEmail());
        dto.setEndereco(fornecedor.getEndereco());
        return dto;
    }

    private Fornecedor convertToEntity(FornecedorDTO dto) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(dto.getNome());
        fornecedor.setTelefone(dto.getTelefone());
        fornecedor.setEmail(dto.getEmail());
        fornecedor.setEndereco(dto.getEndereco());
        return fornecedor;
    }
}
