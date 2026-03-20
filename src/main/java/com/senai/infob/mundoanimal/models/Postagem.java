package com.senai.infob.mundoanimal.models;

import java.time.LocalDate;

import javax.swing.JCheckBox;

import java.sql.Blob;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Postagem")
public class Postagem{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="titulo")
    private String titulo;

    @Column(name="descricao")
    private String descricao;

    @Column(name="localizacao")
    private String localizacao;

    @Column(name="tel_contato")
    private String telContato;

    @Column(name="imagem")
    private Blob imagem;

    @Column(name="data_hora")
    private LocalDate dataHora;

    @Column(name="paginas")
    private JCheckBox paginas;

    @ManyToMany
    @JoinTable(
        name = "postagem_usuario",
        joinColumns = @JoinColumn(name = "postagem_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    )
}
