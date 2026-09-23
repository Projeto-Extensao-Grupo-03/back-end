package school.sptech.projetoDeExtensao;

public class Funcionario {
    private Integer id;
    private String codigo;
    private String nome;
    private Boolean ativo;

    public Funcionario() {
    }

    public Funcionario(Integer id, String codigo, String nome, Boolean ativo) {
        this.id = id;
        this.codigo = codigo;
        this.nome = nome;
        this.ativo = ativo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
