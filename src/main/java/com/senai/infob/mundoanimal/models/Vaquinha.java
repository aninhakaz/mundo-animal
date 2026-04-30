package com.senai.infob.mundoanimal.models;

import java.util.List;

import com.senai.infob.mundoanimal.enums.TipoPagamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    public Vaquinha() {
    }

    public Vaquinha(Integer id, String name, String descricao, String formaPagamento, List<Vaquinha> vaquinha,
            TipoPagamento tipoPagamento) {
        Id = id;
        this.name = name;
        this.descricao = descricao;
        this.formaPagamento = formaPagamento;
        this.vaquinha = vaquinha;
        this.tipoPagamento = tipoPagamento;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<Vaquinha> getVaquinha() {
        return vaquinha;
    }

    public void setVaquinha(List<Vaquinha> vaquinha) {
        this.vaquinha = vaquinha;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    
}