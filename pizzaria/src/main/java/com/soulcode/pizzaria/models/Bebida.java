package com.soulcode.pizzaria.models;

import jakarta.persistence.*;

@Entity
public class Bebida {
     @Id
     @GeneratedValue
     private Long idBebida;
    private String nome;
    private double preco;

    public Bebida() {
    }

    public Bebida(Long idBebida, String nome, double preco) {
        this.idBebida=idBebida;
        this.nome = nome;
        this.preco = preco;
    }

    public Long getId() {
        return idBebida;
    }

    public void setId(Long id) {
        this.idBebida = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "id=" + idBebida+
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                '}';
    }
}
