package com.example.Projeto.Repository;


import com.example.Projeto.Entity.Mecanico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MecanicoRepositoy extends JpaRepository <Mecanico, Integer>{
    Boolean existsByEmailOrCpf(String email, String cpf);
    Optional<Mecanico> findByCodigo(String codigo);
    Boolean existsByCodigo(String codigo);

    Boolean existsByEmailAndIdNot(String email, Integer id);
}
