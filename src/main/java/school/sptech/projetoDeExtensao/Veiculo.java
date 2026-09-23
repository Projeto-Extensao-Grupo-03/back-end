package school.sptech.projetoDeExtensao;

public class Veiculo {
    private Integer id;
    private String placa;
    private String chassi;
    private Integer km;
    private Integer clienteFk;

    public Veiculo() {
    }

    public Veiculo(Integer id, String placa, String chassi, Integer km, Integer clienteFk) {
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.km = km;
        this.clienteFk = clienteFk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Integer getClienteFk() {
        return clienteFk;
    }

    public void setClienteFk(Integer clienteFk) {
        this.clienteFk = clienteFk;
    }
}
