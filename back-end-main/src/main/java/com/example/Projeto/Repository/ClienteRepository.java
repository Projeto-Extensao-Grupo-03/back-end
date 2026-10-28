package com.example.Projeto.Repository;

import com.example.Projeto.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Boolean existsByEmailOrCpf(String email, String cpf);
}
