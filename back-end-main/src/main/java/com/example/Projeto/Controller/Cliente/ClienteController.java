package com.example.Projeto.Controller.Cliente;


import com.example.Projeto.DTO.Cliente.ClienteRequest;
import com.example.Projeto.DTO.Cliente.ClienteResponse;
import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Mapper.ClienteMapper;
import com.example.Projeto.Service.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        List<Cliente> clientes = clienteService.listar();
        List<ClienteResponse> clientesExibir = new ArrayList<>();
        for(int i = 0; i<clientes.size(); i++){
            ClienteResponse response = ClienteMapper.toResponse(clientes.get(i));
            clientesExibir.add(response);
        }
        if (clientes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(clientesExibir);
    }


    @Operation(
            summary = "Busca cliente por ID",
            description = "Retorna os detalhes de um cliente específico utilizando o seu identificador numérico."
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> procurar(@PathVariable Integer id) {
        Cliente cliente = clienteService.procurar(id);
        ClienteResponse response = ClienteMapper.toResponse(cliente);
        return ResponseEntity.status(200).body(response);
    }

    @Operation(
            summary = "Cadastra um novo cliente",
            description = "Recebe os dados do cliente (como nome, CPF, telefone) e salva um novo registro no banco de dados."
    )
    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest request) {
        Cliente cliente = clienteService.cadastrar(request);
        ClienteResponse response = ClienteMapper.toResponse(cliente);
        return ResponseEntity.status(201).body(response);
    }

    @Operation(
            summary = "Atualiza os dados do cliente",
            description = "Busca o cliente pelo ID e atualiza as suas informações com base nos novos dados fornecidos na requisição."
    )
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> att(@PathVariable Integer id, @Valid @RequestBody ClienteRequest request) {
        Cliente cliente = clienteService.atualizar(id, request);
        ClienteResponse response = ClienteMapper.toResponse(cliente);
        return ResponseEntity.status(200).body(response);
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
