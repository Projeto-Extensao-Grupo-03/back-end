package com.example.Projeto.Repository;


import com.example.Projeto.Entity.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MecanicoRepositoy extends JpaRepository <Mecanico, Integer>{
    Boolean existsByEmailOrCpf(String email, String cpf);
}
