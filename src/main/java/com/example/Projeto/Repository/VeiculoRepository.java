package com.example.Projeto.Repository;

import com.example.Projeto.Entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository <Veiculo, Integer> {
}
