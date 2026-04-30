package com.senai.infob.mundoanimal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Endereco")
public class Endereco{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="bairro")
    private String bairro;

    @Column(name="cidade")
    private String cidade;

    @Column(name="rua")
    private String rua;

    @Column(name="cep")
    private String cep;

    @Column(name="uf")
    private String uf;

    public Endereco() {
    }

    public Endereco(Integer id, String bairro, String cidade, String rua, String cep, String uf) {
        Id = id;
        this.bairro = bairro;
        this.cidade = cidade;
        this.rua = rua;
        this.cep = cep;
        this.uf = uf;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    
    

    
}
