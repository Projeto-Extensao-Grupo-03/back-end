package school.sptech.projetoDeExtensao;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final JdbcTemplate jdbcTemplate;

    public ClienteController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @PostMapping
    public ResponseEntity<Cliente> cadastrarCliente (@RequestBody Cliente cliente) {
        String sql = """
                INSERT INTO cliente (nome, telefone, email, data_nascimento) VALUES
                (?,?,?,?)
                """;
        jdbcTemplate.update(sql, cliente.getNome(), cliente.getTelefone(), cliente.getEmail(),
                cliente.getDataNascimento());
    return ResponseEntity.status(201).body(cliente);
    }
}
