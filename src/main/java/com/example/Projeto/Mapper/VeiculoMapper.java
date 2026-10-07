package com.example.Projeto.Mapper;

import com.example.Projeto.DTO.VeiculoRequest;
import com.example.Projeto.DTO.VeiculoResponse;
import com.example.Projeto.Entity.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class VeiculoMapper {

    public static List<VeiculoResponse> toListResponse(List<Veiculo> veiculos) {
        if (veiculos == null) {return null;}

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

    public static VeiculoResponse toResponse(Veiculo veiculo) {
        if (veiculo == null) {return null;}

        return new VeiculoResponse(
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getChassi(),
                veiculo.getKm(),
                veiculo.getCliente()
        );
    }

    public static Veiculo toEntity(VeiculoRequest veiculoRequest) {
        if (veiculoRequest == null) {return null;}

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(veiculoRequest.getPlaca());
        veiculo.setChassi(veiculoRequest.getChassi());
        veiculo.setKm(veiculoRequest.getKm());

        return veiculo;
    }
}
