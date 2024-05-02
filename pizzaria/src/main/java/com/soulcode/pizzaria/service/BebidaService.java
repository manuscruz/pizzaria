package com.soulcode.pizzaria.service;

import com.soulcode.pizzaria.models.Bebida;
import com.soulcode.pizzaria.repository.BebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BebidaService {
    private final BebidaRepository bebidaRepository;

    @Autowired
    public BebidaService(BebidaRepository bebidaRepository) {
        this.bebidaRepository = bebidaRepository;
    }

    public List<Bebida> listarTodasBebidas() {
        return bebidaRepository.findAll();
    }

    public Optional<Bebida> encontrarBebidaPorId(Long id) {
        return bebidaRepository.findById(id);
    }

    public Bebida salvarBebida(Bebida bebida) {
        return bebidaRepository.save(bebida);
    }

    public void excluirBebida(Long id) {
        bebidaRepository.deleteById(id);
    }
}
