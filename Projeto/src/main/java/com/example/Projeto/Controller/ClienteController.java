package com.example.Projeto.Controller;


import com.example.Projeto.DTO.ClienteRequest;
import com.example.Projeto.DTO.ClienteResponse;
import com.example.Projeto.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/usuarios")
public class ClienteController {


    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listar() {
        List<ClienteResponse> clientes = clienteService.listar();
        if (clientes.size() < 1) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(clientes);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> procurar(@PathVariable Integer id) {
        ClienteResponse cliente = clienteService.procurar(id);
        return ResponseEntity.status(200).body(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteResponse> cadastrar(@Valid @RequestBody ClienteRequest request) {
        ClienteResponse cliente = clienteService.cadastrar(request);
        return ResponseEntity.status(201).body(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> att(@PathVariable Integer id, @Valid @RequestBody ClienteRequest request) {
        ClienteResponse cliente = clienteService.att(id, request);
        return ResponseEntity.status(200).body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        clienteService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}
