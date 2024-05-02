package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.Clientes;
import com.soulcode.pizzaria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Clientes> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Clientes> encontrarClientePorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Clientes salvarCliente(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    public void excluirClientePorId(Long id) {
        clienteRepository.deleteById(id);
    }

    public boolean existeCliente(Long id) {
        return clienteRepository.existsById(id);
    }
}
