package com.nexus.Service;


import com.nexus.DTO.ClienteRequest;
import com.nexus.DTO.ClienteResponse;
import com.nexus.Entity.Cliente;
import com.nexus.Exceptions.ClienteJaCadastrado;
import com.nexus.Exceptions.ClienteNaoExiste;
import com.nexus.Mapper.ClienteMapper;
import com.nexus.Repository.ClienteRepository;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteResponse procurar(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new ClienteNaoExiste("Cliente não encontrado");
        }
        Cliente clienteExibir = cliente.get();
        ClienteResponse clienteDaVez = ClienteMapper.toResponse(clienteExibir);

        return clienteDaVez;
    }

    public ClienteResponse cadastrar(ClienteRequest request){
        if(clienteRepository.existsByEmailOrCpf(request.getEmail(), request.getCpf())){
            throw new ClienteJaCadastrado("Já existe um cliente com esssas informações cadastradas!");
        }
        Cliente cliente = ClienteMapper.toEntity(request);
        clienteRepository.save(cliente);
        ClienteResponse response = ClienteMapper.toResponse(cliente);
        return response;
    }

    public List<ClienteResponse> listar(){
        List<Cliente> clientes = clienteRepository.findAll();
        List<ClienteResponse> clientesExibir = new ArrayList<>();
        for(int i = 0; i<clientes.size(); i++){
            ClienteResponse clienteDaVez = ClienteMapper.toResponse(clientes.get(i));
            clientesExibir.add(clienteDaVez);
        }
        return clientesExibir;
    }

    public ClienteResponse att(Integer id, ClienteRequest request){
        if(!clienteRepository.existsById(id)){
            throw new ClienteNaoExiste("Cliente não encontrado!");
        }
        Cliente cliente = ClienteMapper.toEntity(request);
        cliente.setId(id);
        clienteRepository.save(cliente);
        ClienteResponse clienteExibir = ClienteMapper.toResponse(cliente);
        return clienteExibir;
    }

    public void deletar(Integer id){
        if(!clienteRepository.existsById(id)){
            throw new ClienteNaoExiste("Cliente não encontrado!");
        }
        clienteRepository.deleteById(id);
    }


}
