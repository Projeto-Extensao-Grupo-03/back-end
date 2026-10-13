package com.example.Projeto.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "problema")
public class ItemCheckIn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer numeroItem;
    @Column(nullable = false)
    private Boolean temProblema;
    @Column(length = 2000)
    private String observacao;
    @ManyToOne(optional = false)
    @JoinColumn(name = "revisao_inspecao_fk", nullable = false)
    private CheckIn checkIn;

    public ItemCheckIn() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroItem() {
        return numeroItem;
    }

    public void setNumeroItem(Integer numeroItem) {
        this.numeroItem = numeroItem;
    }

    public Boolean getTemProblema() {
        return temProblema;
    }

    public void setTemProblema(Boolean temProblema) {
        this.temProblema = temProblema;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public CheckIn getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(CheckIn checkIn) {
        this.checkIn = checkIn;
    }
}
