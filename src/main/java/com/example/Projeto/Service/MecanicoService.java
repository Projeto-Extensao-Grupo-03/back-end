package com.example.Projeto.Service;

import com.example.Projeto.DTO.ClienteResponse;
import com.example.Projeto.DTO.MecanicoRequest;
import com.example.Projeto.DTO.MecanicoResponse;
import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Entity.Mecanico;

import com.example.Projeto.Exceptions.ClienteNaoExiste;
import com.example.Projeto.Exceptions.EmailJaUtilizado;
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

import static com.example.Projeto.Utils.CodigoFuncionarioUtil.gerarCodigoFuncionario;

@Service
public class MecanicoService {

    private final MecanicoRepositoy mecanicoRepository;

    public MecanicoService(MecanicoRepositoy mecanicoRepositoy) {
        this.mecanicoRepository = mecanicoRepositoy;
    }


    public List<Mecanico> listar() {
        return mecanicoRepository.findAll();
    }

    public Mecanico buscarPorId(Integer id) {
        Optional<Mecanico> mecanico = mecanicoRepository.findById(id);
        if (mecanico.isEmpty()) {
            throw new MecanicoNaoExiste("Mecanico não encontrado");
        }

        return mecanico.get();
    }

    public Mecanico buscarPorCodigo(String codigo) {
        Optional<Mecanico> mecanico = mecanicoRepository.findByCodigo(codigo);
        if (mecanico.isEmpty()) {
            throw new MecanicoNaoExiste("Mecanico não encontrado");
        }

        return mecanico.get();
    }


    public Mecanico cadastrar(Mecanico mecanico) {
        if (mecanicoRepository.existsByEmailOrCpf(mecanico.getEmail(), mecanico.getCpf())) {
            throw new MecanicoJaCadastrado("Esse mecânico já existe no sistema!");
        }

        String codigoFuncionario;
        do {
            codigoFuncionario = gerarCodigoFuncionario(mecanico.getNome());
        } while (mecanicoRepository.existsByCodigo(codigoFuncionario));

        mecanico.setCodigo(codigoFuncionario);


        return  mecanicoRepository.save(mecanico);
    }

    public Mecanico atualizar(Integer id, Mecanico mecanicoAtualizar) {
        Optional<Mecanico> mecanicoOptional = mecanicoRepository.findById(id);

        if (mecanicoOptional.isEmpty()) {
            throw new MecanicoNaoExiste("Não há nenhum mecanico cadastrado com essas informações!");
        }

        if(mecanicoRepository.existsByEmailAndIdNot(mecanicoAtualizar.getEmail(), id)){
            throw new EmailJaUtilizado("Email já cadastrado no sistema!");
        }

        Mecanico mecanicoExistente = new Mecanico(
                id,
                mecanicoOptional.get().getCodigo(),
                mecanicoAtualizar.getNome(),
                mecanicoAtualizar.getAtivo(),
                mecanicoAtualizar.getCpf(),
                mecanicoAtualizar.getDataNascimento(),
                mecanicoAtualizar.getEmail(),
                mecanicoAtualizar.getNumeroTelefone()
        );
        return  mecanicoRepository.save(mecanicoExistente);
    }

    public void deletar(Integer id) {
        if (!mecanicoRepository.existsById(id)) {
            throw new MecanicoNaoExiste("Não há nenhum mecanico cadastrado com essas informações!");
        }
        mecanicoRepository.deleteById(id);
    }
}
