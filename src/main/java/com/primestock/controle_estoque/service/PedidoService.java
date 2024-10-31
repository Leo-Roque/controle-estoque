package com.primestock.controle_estoque.service;

import com.primestock.controle_estoque.dto.PedidoDTO;
import com.primestock.controle_estoque.model.Cliente;
import com.primestock.controle_estoque.model.Pedido;
import com.primestock.controle_estoque.model.Produto;
import com.primestock.controle_estoque.repository.ClienteRepository;
import com.primestock.controle_estoque.repository.PedidoRepository;
import com.primestock.controle_estoque.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
    }

    public List<PedidoDTO> listarTodosPedidos() {
        return pedidoRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<PedidoDTO> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id)
                .map(this::convertToDTO);
    }

    public PedidoDTO criarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = convertToEntity(pedidoDTO);
        return convertToDTO(pedidoRepository.save(pedido));
    }

    public PedidoDTO atualizarPedido(Long id, PedidoDTO pedidoDTO) {
        Pedido pedido = convertToEntity(pedidoDTO);
        pedido.setId(id);
        return convertToDTO(pedidoRepository.save(pedido));
    }

    public void excluirPedido(Long id) {
        pedidoRepository.deleteById(id);
    }

    private PedidoDTO convertToDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setClienteId(pedido.getCliente().getId());
        dto.setProdutoId(pedido.getProduto().getId());
        dto.setQuantidade(pedido.getQuantidade());
        dto.setData(pedido.getData());
        return dto;
    }

    private Pedido convertToEntity(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        
        pedido.setCliente(cliente);
        pedido.setProduto(produto);
        pedido.setQuantidade(dto.getQuantidade());
        pedido.setData(dto.getData());
        return pedido;
    }
}
