package school.sptech.projetoDeExtensao;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrcamentoResposta {
    private Integer id;
    private LocalDateTime dataCriacao;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private String relatoCliente;
    private Double total;
    private String status;
    private String nomeCliente;
    private String telefoneCliente;
    private String emailCliente;
    private String placaVeiculo;
    private String chassiVeiculo;
    private Integer kmVeiculo;
    private String codigoFuncionario;

    public OrcamentoResposta() {
    }

    public Integer getId() {
        return id;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public String getChassiVeiculo() {
        return chassiVeiculo;
    }

    public void setChassiVeiculo(String chassiVeiculo) {
        this.chassiVeiculo = chassiVeiculo;
    }

    public Integer getKmVeiculo() {
        return kmVeiculo;
    }

    public void setKmVeiculo(Integer kmVeiculo) {
        this.kmVeiculo = kmVeiculo;
    }

    public String getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(String codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }
}
