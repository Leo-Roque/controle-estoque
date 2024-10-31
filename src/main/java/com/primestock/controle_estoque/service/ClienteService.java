package com.primestock.controle_estoque.service;

import com.primestock.controle_estoque.dto.ClienteDTO;
import com.primestock.controle_estoque.model.Cliente;
import com.primestock.controle_estoque.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> listarTodosClientes() {
        return clienteRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<ClienteDTO> buscarClientePorId(Long id) {
        return clienteRepository.findById(id)
                .map(this::convertToDTO);
    }

    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        Cliente cliente = convertToEntity(clienteDTO);
        return convertToDTO(clienteRepository.save(cliente));
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        Cliente cliente = convertToEntity(clienteDTO);
        cliente.setId(id);
        return convertToDTO(clienteRepository.save(cliente));
    }

    public void excluirCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    // Métodos auxiliares para conversão
    private ClienteDTO convertToDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setTelefone(cliente.getTelefone());
        dto.setEmail(cliente.getEmail());
        dto.setEndereco(cliente.getEndereco());
        return dto;
    }

    private Cliente convertToEntity(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setTelefone(dto.getTelefone());
        cliente.setEmail(dto.getEmail());
        cliente.setEndereco(dto.getEndereco());
        return cliente;
    }
}
