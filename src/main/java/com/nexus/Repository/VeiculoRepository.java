package com.nexus.Repository;

import com.nexus.Entity.Cliente;
import com.nexus.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository <Veiculo, Integer> {
    Boolean existsByPlacaAndCliente(String placa, Cliente cliente);

    Boolean existsByPlacaAndClienteAndIdNot(String titulo, Cliente cliente, Integer id);
}
