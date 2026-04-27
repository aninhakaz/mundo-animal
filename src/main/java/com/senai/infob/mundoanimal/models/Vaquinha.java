package com.senai.infob.mundoanimal.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Vaquinha")
public class Vaquinha{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="nome_vaquinha")
    private String name;

    @Column(name="descricao")
    private String descricao;

    @Column(name="forma_pagamento")
    private String formaPagamento;

    @ManyToMany
    @JoinTable(
        name = "vaquinha_usuario",
        joinColumns = @JoinColumn(name = "vaquinha_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    )
    private List<Vaquinha> vaquinha;
}