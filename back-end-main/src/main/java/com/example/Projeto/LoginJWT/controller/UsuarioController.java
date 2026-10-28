package com.example.Projeto.LoginJWT.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.Projeto.LoginJWT.dto.*;
import com.example.Projeto.LoginJWT.entity.Usuario;
import com.example.Projeto.LoginJWT.service.UsuarioService;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/auth")
@Tag(name = "Autenticação e Usuários", description = "Endpoints para cadastro de usuários, login, logout e gerenciamento de tokens JWT.")
public class UsuarioController {

    public static final String COOKIE_NOME = "authToken";

    @Value("${jwt.validity}")
    private long jwtValidity;

    @Autowired
    private UsuarioService usuarioService;

    @Operation(
            summary = "Cadastra um novo usuário",
            description = "Cria um novo registro de usuário no banco de dados com e-mail e senha, permitindo o acesso futuro ao sistema."
    )
    @PostMapping
    // @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Void> criar(@RequestBody @Valid UsuarioCriacaoDto usuarioCriacaoDto) {
        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);
        this.usuarioService.criar(novoUsuario);
        return ResponseEntity.status(201).build();
    }

    @Operation(
            summary = "Autentica o usuário (Login)",
            description = "Valida as credenciais fornecidas. Se corretas, gera um token JWT, retorna no corpo da resposta e também o injeta automaticamente em um cookie seguro (HttpOnly) para o frontend."
    )
    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto,
                                                 HttpServletResponse response) {
        final Usuario usuario = UsuarioMapper.of(usuarioLoginDto);
        UsuarioTokenDto autenticado = this.usuarioService.autenticar(usuario);

        ResponseCookie cookie = ResponseCookie.from(COOKIE_NOME, autenticado.getToken())
                .httpOnly(true)
                .secure(false)
                .sameSite("Strict")
                .path("/")
                .maxAge(Duration.ofSeconds(jwtValidity))
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.ok(autenticado);
    }

    @Operation(
            summary = "Encerra a sessão (Logout)",
            description = "Invalida a sessão do usuário atual substituindo o cookie do token JWT por um cookie vazio e com tempo de expiração zerado."
    )
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from(COOKIE_NOME, "")
                .httpOnly(true)
                .secure(false)
                .sameSite("Strict")
                .path("/")
                .maxAge(0)
                .build();

        response.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());

        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Lista todos os usuários",
            description = "Retorna uma lista com os dados básicos de todos os usuários do sistema. Requer envio do token JWT válido na requisição."
    )
    @GetMapping
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<List<UsuarioListarDto>> listarTodos() {
        List<UsuarioListarDto> usuariosEncontrados = this.usuarioService.listarTodos();

        if (usuariosEncontrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.ok(usuariosEncontrados);
    }
}
