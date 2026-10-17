package com.example.Projeto.Controller;

import com.example.Projeto.DTO.CheckInRequest;
import com.example.Projeto.DTO.CheckInResponse;
import com.example.Projeto.DTO.ItemCheckInRequest;
import com.example.Projeto.DTO.ItemCheckInResponse;
import com.example.Projeto.Entity.CheckIn;
import com.example.Projeto.Entity.ItemCheckIn;
import com.example.Projeto.Mapper.CheckInMapper;
import com.example.Projeto.Mapper.ItemCheckInMapper;
import com.example.Projeto.Service.CheckInService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/checkins")
@Tag(name = "Check-ins (Checklists)", description = "Endpoints para emissão e gerenciamento de check-ins de veículos e seus respectivos itens de inspeção.")
public class CheckInController {
    private final CheckInService checkInService;

    public CheckInController(CheckInService checkInService){
        this.checkInService = checkInService;
    }

    @Operation(
            summary = "Lista todos os check-ins",
            description = "Retorna uma lista completa com todos os check-ins registrados, incluindo os itens inspecionados em cada veículo. Retorna status 204 se não houver registros."
    )
    @GetMapping
    public ResponseEntity<List<CheckInResponse>> listar(){
        List<CheckIn> checkIns = checkInService.listar();

        if (checkIns.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        List<CheckInResponse> resposta = new ArrayList<>();

        for (CheckIn checkIn : checkIns) {
            List<ItemCheckIn> itens = checkInService.buscarItens(checkIn.getId());
            resposta.add(CheckInMapper.toResponse(checkIn, itens));
        }

        return ResponseEntity.status(200).body(resposta);
    }

    @Operation(
            summary = "Busca check-in por ID",
            description = "Retorna os detalhes de um check-in específico e a lista completa dos seus itens de inspeção associados."
    )
    @GetMapping("/{id}")
    public ResponseEntity<CheckInResponse> buscarPorId(@PathVariable Integer id){
        CheckIn checkIn = checkInService.buscarPorId(id);
        List<ItemCheckIn> itens = checkInService.buscarItens(id);

        return ResponseEntity.status(200).body(CheckInMapper.toResponse(checkIn, itens));
    }

    @Operation(
            summary = "Cadastra um novo check-in",
            description = "Registra a entrada de um veículo na oficina, vincula ao mecânico responsável e salva simultaneamente todos os itens inspecionados no checklist."
    )
    @PostMapping
    public ResponseEntity<CheckInResponse> cadastrar(@Valid @RequestBody CheckInRequest request){
        CheckIn checkIn = CheckInMapper.toEntity(request);
        List<ItemCheckIn> itens = new ArrayList<>();

        for (ItemCheckInRequest itemRequest : request.getItens()) {
            itens.add(ItemCheckInMapper.toEntity(itemRequest));
        }
        CheckIn checkInSalvo = checkInService.cadastrar(checkIn, request.getMecanicoId(), itens);
        List<ItemCheckIn> itensSalvos = checkInService.buscarItens(checkInSalvo.getId());

         return ResponseEntity.status(201).body(CheckInMapper.toResponse(checkInSalvo, itensSalvos));
    }

    @Operation(
            summary = "Atualiza um check-in existente",
            description = "Substitui os dados gerais do check-in e recria ou atualiza a lista de itens inspecionados vinculados a ele."
    )
    @PutMapping("/{id}")
    public ResponseEntity<CheckInResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody CheckInRequest request) {
        CheckIn dados = CheckInMapper.toEntity(request);
        List<ItemCheckIn> itens = new ArrayList<>();

        for (ItemCheckInRequest itemRequest : request.getItens()) {
            itens.add(ItemCheckInMapper.toEntity(itemRequest));
        }
        CheckIn checkInAtualizado = checkInService.atualizar(dados, id, request.getMecanicoId(), itens);
        List<ItemCheckIn> itensSalvos = checkInService.buscarItens(checkInAtualizado.getId());

        return ResponseEntity.status(200).body(CheckInMapper.toResponse(checkInAtualizado, itensSalvos));
    }

    @Operation(
            summary = "Remove um check-in",
            description = "Exclui permanentemente o registro de um check-in do sistema utilizando o seu ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        checkInService.deletar(id);
        return ResponseEntity.status(200).build();
    }
}
