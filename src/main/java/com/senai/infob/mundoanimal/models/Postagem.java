package com.senai.infob.mundoanimal.models;

import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JCheckBox;

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
    private List<Postagem> postagem;

    
    public Postagem() {
    }

    public Postagem(Integer id, String titulo, String descricao, String localizacao, String telContato, Blob imagem,
            LocalDate dataHora, JCheckBox paginas) {
        Id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.telContato = telContato;
        this.imagem = imagem;
        this.dataHora = dataHora;
        this.paginas = paginas;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public Blob getImagem() {
        return imagem;
    }

    public void setImagem(Blob imagem) {
        this.imagem = imagem;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public JCheckBox getPaginas() {
        return paginas;
    }

    public void setPaginas(JCheckBox paginas) {
        this.paginas = paginas;
    }

   
}
