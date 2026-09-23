package school.sptech.projetoDeExtensao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Orcamento {
    private String nomeCliente;
    private Integer id;
    private LocalDateTime dataCriacao;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String relatoCliente;
    private Double total;
    private String status;
    private Integer clienteFk;
    private Integer veiculoFk;
    private Integer funcionarioFk;

    public Orcamento() {
    }

    public Orcamento(Integer id, LocalDateTime dataCriacao, LocalDate dataEntrada, LocalDate dataSaida, String relatoCliente, Double total, String status, Integer clienteFk, Integer veiculoFk, Integer funcionarioFk, String nomeCliente) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.relatoCliente = relatoCliente;
        this.total = total;
        this.status = status;
        this.clienteFk = clienteFk;
        this.veiculoFk = veiculoFk;
        this.funcionarioFk = funcionarioFk;
        this.nomeCliente = nomeCliente;
    }

    public Integer getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getRelatoCliente() {
        return relatoCliente;
    }

    public void setRelatoCliente(String relatoCliente) {
        this.relatoCliente = relatoCliente;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getClienteFk() {
        return clienteFk;
    }

    public void setClienteFk(Integer clienteFk) {
        this.clienteFk = clienteFk;
    }

    public Integer getVeiculoFk() {
        return veiculoFk;
    }

    public void setVeiculoFk(Integer veiculoFk) {
        this.veiculoFk = veiculoFk;
    }

    public Integer getFuncionarioFk() {
        return funcionarioFk;
    }

    public void setFuncionarioFk(Integer funcionarioFk) {
        this.funcionarioFk = funcionarioFk;
    }
}
