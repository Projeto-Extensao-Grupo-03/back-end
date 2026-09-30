package school.sptech.projetoDeExtensao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {

    private final JdbcTemplate jdbcTemplate;

    public OrcamentoController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping
    public List<OrcamentoResposta> listar() {
//        String sql = """
//        SELECT id, data_criacao, data_entrada, data_saida, relato_cliente, total, status, cliente_fk, veiculo_fk, funcionario_fk
//        FROM orcamento ORDER BY data_criacao DESC
//    """;
        String sql = """
        SELECT
            o.id,
            o.data_criacao,
            o.data_entrada,
            o.data_saida,
            o.relato_cliente,
            o.total,
            o.status,

            c.nome AS nome_cliente,
            c.telefone AS telefone_cliente,
            c.email AS email_cliente,

            v.placa AS placa_veiculo,
            v.chassi AS chassi_veiculo,
            v.km AS km_veiculo,

            f.codigo AS codigo_funcionario

        FROM orcamento o
        JOIN veiculo v ON o.veiculo_fk = v.id
        JOIN cliente c ON v.cliente_fk = c.id
        JOIN funcionario f ON o.funcionario_fk = f.id

        ORDER BY o.data_criacao DESC
        """;

//        String sql = """
//    SELECT o.id, o.data_criacao,o.data_entrada,o.data_saida,o.relato_cliente,o.total,o.status,o.cliente_fk,o.veiculo_fk,o.funcionario_fk,c.nome AS nome_cliente FROM orcamento o
//    JOIN cliente c ON o.cliente_fk = c.id
//    ORDER BY o.data_criacao DESC
//    """;

        return jdbcTemplate.query(
                sql, new BeanPropertyRowMapper<>(OrcamentoResposta.class)
        );
    }
}
