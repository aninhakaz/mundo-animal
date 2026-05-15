package com.senai.infob.mundoanimal.models; 
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table; 


@Entity 
@Table(name="Usuario") 

public class Usuario{ 
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name="id") 
    private Integer Id; 

    @Column(name="nome_completo") 
    private String nomeCompleto; 

    @Column(name="data_nascimento") 
    private LocalDate dataNascimento; 

    @Column(name="email") 
    private String email; 
 
    @Column(name="cpf") 
    private String cpf; 

    @Column(name="senha") 
    private String senha; 

    @Column(name="imagem") 
    private String imagem; 

    @ManyToOne @JoinColumn(name="postagem_id", nullable= true) 
    private Postagem postagem; 
    @ManyToOne @JoinColumn(name="doacao_id", nullable= true) 
    private Doacao doacao; 
    @ManyToOne @JoinColumn(name="vaquinha_id", nullable= true) 
    private Vaquinha vaquinha;

    public Usuario() {
    }

    public Usuario(Integer Id, String cpf, LocalDate dataNascimento, String email, String imagem, String nomeCompleto, String senha) {
        this.Id = Id;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.imagem = imagem;
        this.nomeCompleto = nomeCompleto;
        this.senha = senha;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }


}