package com.example.Projeto.Controller;


import com.example.Projeto.DTO.ClienteRequest;
import com.example.Projeto.DTO.ClienteResponse;
import com.example.Projeto.Service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clientes")
@Tag(name = "Clientes", description = "Endpoints para cadastro, listagem e gerenciamento de clientes da oficina.")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @Operation(
            summary = "Lista todos os clientes",
            description = "Retorna uma lista completa com todos os clientes cadastrados. Caso não exista nenhum cliente, retorna o status 204 (No Content)."
    )
    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        List<ClienteResponse> clientes = clienteService.listar();
        if (clientes.size() < 1) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(clientes);
    }


    @Operation(
            summary = "Busca cliente por ID",
            description = "Retorna os detalhes de um cliente específico utilizando o seu identificador numérico."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> procurar(@PathVariable Integer id) {
        ClienteResponse cliente = clienteService.procurar(id);
        return ResponseEntity.status(200).body(cliente);
    }

    @Operation(
            summary = "Cadastra um novo cliente",
            description = "Recebe os dados do cliente (como nome, CPF, telefone) e salva um novo registro no banco de dados."
    )
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest request) {
        ClienteResponse cliente = clienteService.cadastrar(request);
        return ResponseEntity.status(201).body(cliente);
    }

    @Operation(
            summary = "Atualiza os dados do cliente",
            description = "Busca o cliente pelo ID e atualiza as suas informações com base nos novos dados fornecidos na requisição."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> att(@PathVariable Integer id, @Valid @RequestBody ClienteRequest request) {
        ClienteResponse cliente = clienteService.att(id, request);
        return ResponseEntity.status(200).body(cliente);
    }

    @Operation(
            summary = "Remove um cliente",
            description = "Exclui permanentemente o registro de um cliente do sistema utilizando o seu ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        clienteService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}
