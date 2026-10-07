package com.example.Projeto.Repository;

import com.example.Projeto.Entity.Cliente;
import com.example.Projeto.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository <Veiculo, Integer> {
    Boolean existsByPlacaAndCliente(String placa, Cliente cliente);

    Boolean existsByPlacaAndClienteAndIdNot(String titulo, Cliente cliente, Integer id);
}
