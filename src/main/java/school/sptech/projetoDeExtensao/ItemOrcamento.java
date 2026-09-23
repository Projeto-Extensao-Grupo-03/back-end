package school.sptech.projetoDeExtensao;

public class ItemOrcamento {
    private Integer id;
    private Integer quantidade;
    private Double precoUnitario;
    private Double precoFinal;
    private String descricao;
    private Integer orcamentoFk;
    private Integer pecaFk;

    public ItemOrcamento() {
    }

    public ItemOrcamento(Integer id, Integer quantidade, Double precoUnitario, Double precoFinal, String descricao, Integer orcamentoFk, Integer pecaFk) {
        this.id = id;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoFinal = precoFinal;
        this.descricao = descricao;
        this.orcamentoFk = orcamentoFk;
        this.pecaFk = pecaFk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrcamentoFk() {
        return orcamentoFk;
    }

    public void setOrcamentoFk(Integer orcamentoFk) {
        this.orcamentoFk = orcamentoFk;
    }

    public Integer getPecaFk() {
        return pecaFk;
    }

    public void setPecaFk(Integer pecaFk) {
        this.pecaFk = pecaFk;
    }
}
