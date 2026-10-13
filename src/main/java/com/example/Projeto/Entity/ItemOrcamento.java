package com.example.Projeto.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_orcamento")
public class ItemOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 255)
    private String descricao;
    @Column(nullable = false)
    private Integer quantidade;
    @Column(nullable = false)
    private Double precoUnitario;
    @Column(nullable = false)
    private Double precoFinal;
    @ManyToOne(optional = false)
    @JoinColumn(name = "orcamento_fk", nullable = false)
    private Orcamento orcamento;
    @ManyToOne
    @JoinColumn(name = "item_check_in_fk")
    private ItemCheckIn itemCheckIn;

    public ItemOrcamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public ItemCheckIn getItemCheckIn() {
        return itemCheckIn;
    }

    public void setItemCheckIn(ItemCheckIn itemCheckIn) {
        this.itemCheckIn = itemCheckIn;
    }
}