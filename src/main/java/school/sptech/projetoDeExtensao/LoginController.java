package school.sptech.projetoDeExtensao;

import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {
    private final JdbcTemplate jdbcTemplate;

    public LoginController(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Usuario usuario){
        String sql = """
                SELECT COUNT(*) FROM usuario WHERE usuario = ? AND senha = ?
                """;
        Integer qtd = jdbcTemplate.queryForObject(
                sql, Integer.class, usuario.getUsuario(), usuario.getSenha()
        );
        if (qtd > 0){
            return ResponseEntity.status(200).body("Login realizado");
        }
        return ResponseEntity.status(404).build();
    }
}
