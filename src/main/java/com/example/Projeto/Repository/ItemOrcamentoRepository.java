package com.example.Projeto.Repository;

import com.example.Projeto.Entity.ItemOrcamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemOrcamentoRepository extends JpaRepository<ItemOrcamento, Integer> {
    List<ItemOrcamento> findByOrcamento_IdOrderByIdAsc(Integer orcamentoId);
}
