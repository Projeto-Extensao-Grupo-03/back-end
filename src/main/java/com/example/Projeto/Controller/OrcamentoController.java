package com.example.Projeto.Controller;

import com.example.Projeto.DTO.ItemOrcamentoRequest;
import com.example.Projeto.DTO.OrcamentoRequest;
import com.example.Projeto.DTO.OrcamentoResponse;
import com.example.Projeto.DTO.StatusOrcamentoRequest;
import com.example.Projeto.Entity.ItemOrcamento;
import com.example.Projeto.Entity.Orcamento;
import com.example.Projeto.Mapper.ItemOrcamentoMapper;
import com.example.Projeto.Mapper.OrcamentoMapper;
import com.example.Projeto.Service.OrcamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orcamentos")
public class OrcamentoController {
    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @GetMapping
    public ResponseEntity<List<OrcamentoResponse>> listarOrcamento(){
        List<Orcamento> orcamentos = orcamentoService.listar();

        if (orcamentos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        List<OrcamentoResponse> resposta = new ArrayList<>();

        for (Orcamento orcamento : orcamentos) {
            List<ItemOrcamento> itens = orcamentoService.buscarItens(orcamento.getId());
            resposta.add(OrcamentoMapper.toResponse(orcamento, itens));
        }
        return ResponseEntity.status(200).body(resposta);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoResponse> buscarPorId(@PathVariable Integer id) {
        Orcamento orcamento = orcamentoService.buscarPorId(id);
        List<ItemOrcamento> itens = orcamentoService.buscarItens(id);

        return ResponseEntity.ok(OrcamentoMapper.toResponse(orcamento, itens));
    }

    @PostMapping
    public ResponseEntity<OrcamentoResponse> cadastrar(@Valid @RequestBody OrcamentoRequest request) {
        List<ItemOrcamento> itens = new ArrayList<>();

        for (ItemOrcamentoRequest itemRequest : request.getItens()) {
            itens.add(ItemOrcamentoMapper.toEntity(itemRequest));
        }
        Orcamento orcamentoSalvo = orcamentoService.cadastrar(request.getCheckInId(), request.getClienteId(), request.getVeiculoId(), itens);
        List<ItemOrcamento> itensSalvos = orcamentoService.buscarItens(orcamentoSalvo.getId());

        return ResponseEntity.status(201).body(OrcamentoMapper.toResponse(orcamentoSalvo, itensSalvos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrcamentoResponse> atualizar(@PathVariable Integer id, @Valid @RequestBody OrcamentoRequest request) {
        List<ItemOrcamento> itens = new ArrayList<>();

        for (ItemOrcamentoRequest itemRequest : request.getItens()) {
            itens.add(ItemOrcamentoMapper.toEntity(itemRequest));
        }
        Orcamento orcamentoAtualizado = orcamentoService.atualizar(id, request.getCheckInId(), request.getClienteId(), request.getVeiculoId(), itens);
        List<ItemOrcamento> itensSalvos = orcamentoService.buscarItens(orcamentoAtualizado.getId());

        return ResponseEntity.ok(OrcamentoMapper.toResponse(orcamentoAtualizado, itensSalvos));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<OrcamentoResponse> atualizarStatus(@PathVariable Integer id, @Valid @RequestBody StatusOrcamentoRequest request) {
        Orcamento orcamento = orcamentoService.atualizarStatus(id, request.getStatus());
        List<ItemOrcamento> itens = orcamentoService.buscarItens(id);

        return ResponseEntity.ok(OrcamentoMapper.toResponse(orcamento, itens));
    }
}
