package com.example.Projeto.Controller;

import com.example.Projeto.DTO.MecanicoRequest;
import com.example.Projeto.DTO.MecanicoResponse;
import com.example.Projeto.Entity.Mecanico;
import com.example.Projeto.Service.MecanicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialException;
import java.util.List;

import static com.example.Projeto.Mapper.MecanicoMapper.*;

@RestController
@RequestMapping("/mecanico")
@Tag(name = "Mecânicos", description = "Endpoints para cadastro, listagem e gerenciamento do quadro de mecânicos.")
public class MecanicoController {

    private final MecanicoService mecanicoService;

    public MecanicoController(MecanicoService mecanicoService) {
        this.mecanicoService = mecanicoService;
    }

    @Operation(
            summary = "Lista todos os mecânicos",
            description = "Retorna uma lista completa com todos os mecânicos cadastrados na oficina."
    )
    @GetMapping
    public ResponseEntity<List<MecanicoResponse>> listar(){
        return ResponseEntity.status(200).body( listEntityToResponse(mecanicoService.listar()));
    }


    @Operation(
            summary = "Busca mecânico por ID",
            description = "Retorna os detalhes de um mecânico específico utilizando o seu identificador numérico."
    )
    @GetMapping("/{id}")
    public ResponseEntity<MecanicoResponse> procurar(@PathVariable Integer id) {
        Mecanico mecanico = mecanicoService.buscarPorId(id);
        return ResponseEntity.status(200).body(toResponse(mecanico));
    }


    @Operation(
            summary = "Busca mecânico por código interno",
            description = "Retorna os detalhes de um mecânico utilizando o seu código único de 5 caracteres gerado pelo sistema (ex: HOMAB)."
    )
    @GetMapping("buscar/{codigo}")
    public ResponseEntity<MecanicoResponse> procurar(@PathVariable String codigo) {
        return ResponseEntity.status(200).body(toResponse(mecanicoService.buscarPorCodigo(codigo)));
    }

    @Operation(
            summary = "Cadastra um novo mecânico",
            description = "Recebe os dados, realiza as validações e gera automaticamente o código interno de identificação antes de salvar no banco de dados."
    )
    @PostMapping
    public ResponseEntity<MecanicoResponse> cadastrar(@Valid @RequestBody MecanicoRequest request){
        return ResponseEntity.status(201).body(toResponse(mecanicoService.cadastrar(toEntity(request))));
    }

    @Operation(
            summary = "Atualiza os dados do mecânico",
            description = "Busca o mecânico pelo ID e atualiza as informações fornecidas, mantendo o código de identificação original intacto."
    )
    @PutMapping("/{id}")
    public ResponseEntity<MecanicoResponse> att(@PathVariable Integer id, @Valid @RequestBody MecanicoRequest request){
        Mecanico mecanicoParaSalvar = toEntity(request);

        return ResponseEntity.status(200).body(toResponse(mecanicoService.atualizar(id,mecanicoParaSalvar)));
    }

    @Operation(
            summary = "Remove um mecânico do sistema",
            description = "Exclui o registro de um mecânico do banco de dados utilizando o seu ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        mecanicoService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}

