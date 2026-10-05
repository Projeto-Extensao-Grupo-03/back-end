package com.example.Projeto.Mapper;

import com.example.Projeto.DTO.VeiculoResponse;
import com.example.Projeto.Entity.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoMapper {

    public static List<VeiculoResponse> toListResponse(List<Veiculo> veiculos) {
        List<VeiculoResponse> veiculosRepsponse = new ArrayList<>();

        for (Veiculo veiculo : veiculos) {
            VeiculoResponse veiculoResponse = new VeiculoResponse(
                    veiculo.getId(),
                    veiculo.getPlaca(),
                    veiculo.getChassi(),
                    veiculo.getKm(),
                    veiculo.getCliente()
            );

            veiculosRepsponse.add(veiculoResponse);
        }

        return veiculosRepsponse;
    }
}
