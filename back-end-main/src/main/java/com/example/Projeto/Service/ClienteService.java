package com.example.Projeto.Service;


import com.example.Projeto.DTO.Cliente.ClienteRequest;
import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Exceptions.Cliente.ClienteJaCadastrado;
import com.example.Projeto.Exceptions.Cliente.ClienteNaoExiste;
import com.example.Projeto.Mapper.ClienteMapper;
import com.example.Projeto.Repository.ClienteRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente procurar(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new ClienteNaoExiste("Cliente não encontrado");
        }
        return cliente.get();
    }

    public Cliente cadastrar(ClienteRequest request){
        if(clienteRepository.existsByEmailOrCpf(request.getEmail(), request.getCpf())){
            throw new ClienteJaCadastrado("Já existe um cliente com esssas informações cadastradas!");
        }
        Cliente cliente = ClienteMapper.toEntity(request);
        clienteRepository.save(cliente);
        return cliente;
    }

    public List<Cliente> listar(){
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    public Cliente atualizar(Integer id, ClienteRequest request){
        if(!clienteRepository.existsById(id)){
            throw new ClienteNaoExiste("Cliente não encontrado!");
        }
        Cliente cliente = ClienteMapper.toEntity(request);
        cliente.setId(id);
        clienteRepository.save(cliente);
        return cliente;
    }

    public void deletar(Integer id){
        if(!clienteRepository.existsById(id)){
            throw new ClienteNaoExiste("Cliente não encontrado!");
        }
        clienteRepository.deleteById(id);
    }
}
