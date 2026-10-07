package com.example.Projeto.Controller;

import com.example.Projeto.DTO.MecanicoRequest;
import com.example.Projeto.DTO.MecanicoResponse;
import com.example.Projeto.Service.MecanicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {

    private final MecanicoService mecanicoService;

    public MecanicoController(MecanicoService mecanicoService) {
        this.mecanicoService = mecanicoService;
    }
    @GetMapping
    public ResponseEntity<List<MecanicoResponse>> listar(){
        List<MecanicoResponse> mecanicos = mecanicoService.listar();
        if (mecanicos.size() < 1) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(mecanicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanicoResponse> procurar(@PathVariable Integer id) {
        MecanicoResponse mecanico = mecanicoService.buscar(id);
        return ResponseEntity.status(200).body(mecanico);
    }

    @PostMapping
    public ResponseEntity<MecanicoResponse> cadastrar(@Valid MecanicoRequest request){
        MecanicoResponse mecanico = mecanicoService.cadastrar(request);
        return ResponseEntity.status(201).body(mecanico);
    }

    @PutMapping("/{id}")
    public MecanicoResponse att(@PathVariable Integer id, @Valid @RequestBody MecanicoRequest request){
        MecanicoResponse mecanico = mecanicoService.att(id, request);
        return mecanico;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        mecanicoService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}

