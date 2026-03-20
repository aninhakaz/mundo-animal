package com.senai.infob.mundoanimal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="Servicos")
public class Servicos{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="nome_servico")
    private String nomeServico;

    @Column(name="descricao")
    private String descricao;

    @ManyToOne
        @JoinColumn(name="usuario_id", nullable = false)
        private Usuario usuario;

    public Servicos() {
    }

    public Servicos(Integer id, String nomeServico, String descricao, Usuario usuario) {
        Id = id;
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

        

}
