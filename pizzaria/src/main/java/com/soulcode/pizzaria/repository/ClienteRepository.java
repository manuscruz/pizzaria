package com.soulcode.pizzaria.repository;

import com.soulcode.pizzaria.models.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {
    // Consultar cliente por id
    Optional<Clientes> findById(Long id);

    // Excluir cliente por id
    void deleteById(Long id);
}
