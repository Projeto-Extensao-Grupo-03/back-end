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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orcamentos")
@Tag(name = "Orçamentos", description = "Endpoints para criação, aprovação e gerenciamento de orçamentos e seus itens vinculados.")
public class OrcamentoController {
    private final OrcamentoService orcamentoService;

    public OrcamentoController(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    @Operation(
            summary = "Lista todos os orçamentos",
            description = "Retorna uma lista completa com todos os orçamentos e seus respectivos itens de serviço/peças. Retorna status 204 (No Content) se a lista estiver vazia."
    )
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

    @Operation(
            summary = "Busca orçamento por ID",
            description = "Retorna os detalhes de um orçamento específico, incluindo todos os itens, serviços e valores associados a ele."
    )
    @GetMapping("/{id}")
    public ResponseEntity<OrcamentoResponse> buscarPorId(@PathVariable Integer id) {
        Orcamento orcamento = orcamentoService.buscarPorId(id);
        List<ItemOrcamento> itens = orcamentoService.buscarItens(id);

        return ResponseEntity.ok(OrcamentoMapper.toResponse(orcamento, itens));
    }

    @Operation(
            summary = "Cadastra um novo orçamento",
            description = "Cria um novo orçamento vinculando-o a um Check-In, Cliente e Veículo, e salva todos os itens (peças e serviços) informados na requisição."
    )
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

    @Operation(
            summary = "Atualiza um orçamento completo",
            description = "Substitui os dados principais do orçamento e recria ou atualiza a lista de itens vinculados a ele."
    )
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

    @Operation(
            summary = "Atualiza o status do orçamento",
            description = "Altera especificamente o status de aprovação de um orçamento (PENDENTE,EM_ANDAMENTO, FINALIZADO, ENTREGUE, CANCELADO) utilizando o método PATCH, sem modificar os outros dados ou itens."
    )
    @PatchMapping("/{id}/status")
    public ResponseEntity<OrcamentoResponse> atualizarStatus(@PathVariable Integer id, @Valid @RequestBody StatusOrcamentoRequest request) {
        Orcamento orcamento = orcamentoService.atualizarStatus(id, request.getStatus());
        List<ItemOrcamento> itens = orcamentoService.buscarItens(id);

        return ResponseEntity.ok(OrcamentoMapper.toResponse(orcamento, itens));
    }
}
