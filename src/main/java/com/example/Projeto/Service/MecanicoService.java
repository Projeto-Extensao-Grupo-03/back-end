package com.example.Projeto.Service;

import com.example.Projeto.DTO.ClienteResponse;
import com.example.Projeto.DTO.MecanicoRequest;
import com.example.Projeto.DTO.MecanicoResponse;
import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Entity.Mecanico;

import com.example.Projeto.Exceptions.ClienteNaoExiste;
import com.example.Projeto.Exceptions.MecanicoJaCadastrado;
import com.example.Projeto.Exceptions.MecanicoNaoExiste;
import com.example.Projeto.Mapper.ClienteMapper;
import com.example.Projeto.Mapper.MecanicoMapper;
import com.example.Projeto.Repository.MecanicoRepositoy;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MecanicoService {

    private final MecanicoRepositoy mecanicoRepository;

    public MecanicoService(MecanicoRepositoy mecanicoRepositoy) {
        this.mecanicoRepository = mecanicoRepositoy;
    }


    public List<MecanicoResponse> listar() {
        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        List<MecanicoResponse> mecanicosExibir = new ArrayList<>();
        for (int i = 0; i < mecanicos.size(); i++) {
            MecanicoResponse mecanicoDaVez = MecanicoMapper.toResponse(mecanicos.get(i));
            mecanicosExibir.add(mecanicoDaVez);
        }
        return mecanicosExibir;
    }

    public MecanicoResponse buscar(Integer id) {
        Optional<Mecanico> mecanico = mecanicoRepository.findById(id);
        if (mecanico.isEmpty()) {
            throw new MecanicoNaoExiste("Mecanico não encontrado");
        }
        Mecanico mecanicoExibir = mecanico.get();
        MecanicoResponse mecanicoDaVez = MecanicoMapper.toResponse(mecanicoExibir);

        return mecanicoDaVez;
    }

    public MecanicoResponse cadastrar(@Valid MecanicoRequest request) {
        if (mecanicoRepository.existsByEmailOrCpf(request.getEmail(), request.getCpf())) {
            throw new MecanicoJaCadastrado("Um mecânico já foi cadastrado com essas informações!");
        }

        Mecanico mecanico = MecanicoMapper.toEntity(request);
        mecanicoRepository.save(mecanico);
        MecanicoResponse response = MecanicoMapper.toResponse(mecanico);

        return response;
    }

    public MecanicoResponse att(Integer id, MecanicoRequest request) {
        if (!mecanicoRepository.existsById(id)) {
            throw new MecanicoNaoExiste("Não há nenhum mecanico cadastrado com essas informações!");
        }
        Mecanico mecanico = MecanicoMapper.toEntity(request);
        mecanico.setId(id);
        mecanicoRepository.save(mecanico);
        MecanicoResponse response = MecanicoMapper.toResponse(mecanico);
        return response;
    }

    public void deletar(Integer id) {
        if (!mecanicoRepository.existsById(id)) {
            throw new MecanicoNaoExiste("Não há nenhum mecanico cadastrado com essas informações!");
        }
        mecanicoRepository.deleteById(id);
    }
}
