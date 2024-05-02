package com.soulcode.pizzaria.controller;

import com.soulcode.pizzaria.models.Bebida;
import com.soulcode.pizzaria.service.BebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bebidas")
public class BebidaController {

    private final BebidaService bebidaService;

    @Autowired
    public BebidaController(BebidaService bebidaService) {
        this.bebidaService = bebidaService;
    }

    @GetMapping
    public ResponseEntity<List<Bebida>> listarTodasBebidas() {
        List<Bebida> bebidas = bebidaService.listarTodasBebidas();
        return ResponseEntity.ok(bebidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bebida> encontrarBebidaPorId(@PathVariable Long id) {
        return bebidaService.encontrarBebidaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Bebida> adicionarBebida(@RequestBody Bebida bebida) {
        Bebida novaBebida = bebidaService.salvarBebida(bebida);
        return ResponseEntity.ok(novaBebida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bebida> editarBebida(@PathVariable Long id, @RequestBody Bebida bebida) {
        if (!bebidaService.encontrarBebidaPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bebida.setId(id);
        Bebida bebidaEditada = bebidaService.salvarBebida(bebida);
        return ResponseEntity.ok(bebidaEditada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirBebida(@PathVariable Long id) {
        if (!bebidaService.encontrarBebidaPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        bebidaService.excluirBebida(id);
        return ResponseEntity.noContent().build();
    }
}
