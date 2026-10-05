package com.example.Projeto.Controller;

import com.example.Projeto.DTO.VeiculoResponse;
import com.example.Projeto.Entity.Veiculo;
import com.example.Projeto.Mapper.VeiculoMapper;
import com.example.Projeto.Service.VeiculoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
