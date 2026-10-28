package com.example.Projeto.Repository;

import com.example.Projeto.Entity.Orcamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {
    boolean existsByCheckIn_Id(Integer checkInId);
}
