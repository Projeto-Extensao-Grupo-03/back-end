package com.nexus.Repository;

import com.nexus.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Boolean existsByEmailOrCpf(String email, String cpf);
}
