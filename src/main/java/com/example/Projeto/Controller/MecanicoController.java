package com.example.Projeto.Controller;

import com.example.Projeto.DTO.MecanicoRequest;
import com.example.Projeto.DTO.MecanicoResponse;
import com.example.Projeto.Entity.Mecanico;
import com.example.Projeto.Service.MecanicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;
import java.util.List;

import static com.example.Projeto.Mapper.MecanicoMapper.*;

@RestController
@RequestMapping("/mecanico")
public class MecanicoController {

    private final MecanicoService mecanicoService;

    public MecanicoController(MecanicoService mecanicoService) {
        this.mecanicoService = mecanicoService;
    }
    @GetMapping
    public ResponseEntity<List<MecanicoResponse>> listar(){
        return ResponseEntity.status(200).body( listEntityToResponse(mecanicoService.listar()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MecanicoResponse> procurar(@PathVariable Integer id) {
        Mecanico mecanico = mecanicoService.buscarPorId(id);
        return ResponseEntity.status(200).body(toResponse(mecanico));
    }

    @GetMapping("buscar/{codigo}")
    public ResponseEntity<MecanicoResponse> procurar(@PathVariable String codigo) {
        return ResponseEntity.status(200).body(toResponse(mecanicoService.buscarPorCodigo(codigo)));
    }

    @PostMapping
    public ResponseEntity<MecanicoResponse> cadastrar(@Valid MecanicoRequest request){
        return ResponseEntity.status(201).body(toResponse(mecanicoService.cadastrar(toEntity(request))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MecanicoResponse> att(@PathVariable Integer id, @Valid @RequestBody MecanicoRequest request){
        Mecanico mecanicoParaSalvar = toEntity(request);

        return ResponseEntity.status(200).body(toResponse(mecanicoService.atualizar(id,mecanicoParaSalvar)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        mecanicoService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}

