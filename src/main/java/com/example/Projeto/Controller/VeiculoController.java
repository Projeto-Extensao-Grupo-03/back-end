package com.example.Projeto.Controller;

import com.example.Projeto.DTO.VeiculoRequest;
import com.example.Projeto.DTO.VeiculoResponse;
import com.example.Projeto.Entity.Veiculo;
import com.example.Projeto.Mapper.VeiculoMapper;
import com.example.Projeto.Service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> listar() {
        List<Veiculo> veiculos = veiculoService.listar();
        return ResponseEntity.status(200).body(VeiculoMapper.toListResponse(veiculos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> buscarPorId(@PathVariable Integer id) {
        Veiculo veiculo = veiculoService.buscarPorId(id);
        return ResponseEntity.status(200).body(VeiculoMapper.toResponse(veiculo));
    }

    @PostMapping
    public ResponseEntity<VeiculoResponse> cadastrar(@Valid @RequestBody VeiculoRequest veiculoRequest) {
        Veiculo veiculo = veiculoService.cadastrar(VeiculoMapper.toEntity(veiculoRequest), veiculoRequest.getClienteId());
        return ResponseEntity.status(201).body(VeiculoMapper.toResponse(veiculo));
    }
}
