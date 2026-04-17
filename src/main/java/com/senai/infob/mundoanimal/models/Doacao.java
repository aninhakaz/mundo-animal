package com.senai.infob.mundoanimal.models;

import java.util.List;

import com.senai.infob.mundoanimal.enums.TipoPagamento;

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
@Table(name="Doacao")
public class Doacao{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer Id;

    @Column(name="pagamento")
    private TipoPagamento pagamento;

    public Doacao(TipoPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public TipoPagamento getPagamento() {
        return pagamento;
    }

    @Column(name="material")
    private String material;

    @Column(name="tel_contato")
    private String telContato;


    @ManyToMany
    @JoinTable(
        name = "doacao_usuario",
        joinColumns = @JoinColumn(name = "doacao_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    )
    private List<Doacao> doacao;

    public Doacao() {
    }

    public Doacao(Integer id, TipoPagamento pagamento, String material, String telContato, List<Doacao> doacao) {
        Id = id;
        this.pagamento = pagamento;
        this.material = material;
        this.telContato = telContato;
        this.doacao = doacao;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setPagamento(TipoPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getTelContato() {
        return telContato;
    }

    public void setTelContato(String telContato) {
        this.telContato = telContato;
    }

    public List<Doacao> getDoacao() {
        return doacao;
    }

    public void setDoacao(List<Doacao> doacao) {
        this.doacao = doacao;
    }

}
