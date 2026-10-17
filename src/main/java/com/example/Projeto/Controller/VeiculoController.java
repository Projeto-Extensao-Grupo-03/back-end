package com.example.Projeto.Controller;

import com.example.Projeto.DTO.VeiculoRequest;
import com.example.Projeto.DTO.VeiculoResponse;
import com.example.Projeto.Entity.Veiculo;
import com.example.Projeto.Mapper.VeiculoMapper;
import com.example.Projeto.Service.VeiculoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
@Tag(name = "Veículos", description = "Endpoints para cadastro, listagem e gerenciamento dos veículos dos clientes.")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @Operation(
            summary = "Lista todos os veículos",
            description = "Retorna uma lista completa com todos os veículos cadastrados na oficina. Retorna status 204 (No Content) se não houver registros."
    )
    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> listar() {
        List<Veiculo> veiculos = veiculoService.listar();
        if (veiculos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(VeiculoMapper.toListResponse(veiculos));
    }

    @Operation(
            summary = "Busca veículo por ID",
            description = "Retorna os detalhes de um veículo específico utilizando o seu identificador numérico."
    )
    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> buscarPorId(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.buscarPorId(id);
        return ResponseEntity.status(200).body(VeiculoMapper.toResponse(veiculo));
    }

    @Operation(
            summary = "Cadastra um novo veículo",
            description = "Recebe os dados do veículo (placa, modelo, marca, etc.) e o vincula ao ID de um cliente existente no sistema."
    )
    @PostMapping
    public ResponseEntity<VeiculoResponse> cadastrar(@Valid @RequestBody VeiculoRequest veiculoRequest) {
        Veiculo veiculo = veiculoService.cadastrar(VeiculoMapper.toEntity(veiculoRequest), veiculoRequest.getClienteId());
        return ResponseEntity.status(201).body(VeiculoMapper.toResponse(veiculo));
    }

    @Operation(
            summary = "Atualiza os dados do veículo",
            description = "Busca o veículo pelo ID e atualiza suas informações com base nos novos dados fornecidos, mantendo ou alterando o vínculo com o cliente."
    )
    @PutMapping("/{id}")
    public ResponseEntity<VeiculoResponse> atualizar(@Valid @RequestBody VeiculoRequest veiculoRequest, @PathVariable Integer id) {
        Veiculo veiculo = veiculoService.atualizar(VeiculoMapper.toEntity(veiculoRequest), id, veiculoRequest.getClienteId());
        return ResponseEntity.status(200).body(VeiculoMapper.toResponse(veiculo));
    }
}
