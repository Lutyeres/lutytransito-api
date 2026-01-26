package com.lutyeres.lutytransito.api.model;

import com.lutyeres.lutytransito.domain.model.StatusVeiculo;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
public class VeiculoRepresentationModel {

    private Long id;
    private String nomeProprietario;
    private String marca;
    private String modelo;
    private String placa;
    private OffsetDateTime dataApreensao;
    private OffsetDateTime dataCadastro;
    private StatusVeiculo status;


}
