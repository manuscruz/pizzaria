package com.soulcode.pizzaria.controller;


import com.soulcode.pizzaria.models.Clientes;
import com.soulcode.pizzaria.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> listarTodosClientes() {
        List<Clientes> clientes = clienteService.listarTodosClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> consultarClientePorId(@PathVariable Long id) {
        Optional<Clientes> cliente = clienteService.encontrarClientePorId(id);
        return cliente.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Clientes> salvarCliente(@RequestBody Clientes cliente) {
        Clientes clienteSalvo = clienteService.salvarCliente(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> editarCliente(@PathVariable Long id, @RequestBody Clientes cliente) {
        if (!clienteService.existeCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setIdCliente(id);
        Clientes clienteEditado = clienteService.salvarCliente(cliente);
        return ResponseEntity.ok(clienteEditado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirClientePorId(@PathVariable Long id) {
        if (!clienteService.existeCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.excluirClientePorId(id);
        return ResponseEntity.noContent().build();
    }
}
