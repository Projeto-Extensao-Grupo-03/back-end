package com.example.Projeto.Controller;

import com.example.Projeto.DTO.FuncionarioResponse;
import com.example.Projeto.DTO.VeiculoResponse;
import com.example.Projeto.Entity.Funcionario;
import com.example.Projeto.Service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Projeto.Mapper.FuncionarioMapper.toListResponse;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioResponse>> listar() {
        return ResponseEntity.status(200).body(toListResponse(funcionarioService.listarAll()));
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<FuncionarioResponse> buscarByCodigo(@PathVariable String codigo) {

    }

    @PostMapping
    public ResponseEntity<FuncionarioResponse> cadastrar(@PathVariable String codigo) {

    }

    @PutMapping
    public ResponseEntity<FuncionarioResponse> atualizar(@RequestBody Funcionario funcionario) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {

    }

}