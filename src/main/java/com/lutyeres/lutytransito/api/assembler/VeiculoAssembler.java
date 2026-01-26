package com.lutyeres.lutytransito.api.assembler;

import com.lutyeres.lutytransito.api.model.VeiculoRepresentationModel;
import com.lutyeres.lutytransito.api.model.input.VeiculoInputRepresentationModel;
import com.lutyeres.lutytransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class VeiculoAssembler {

    private final ModelMapper modelMapper;

    public Veiculo toEntity(VeiculoInputRepresentationModel veiculoInputRepresentationModel){
        return modelMapper.map(veiculoInputRepresentationModel, Veiculo.class);
    }

    public VeiculoRepresentationModel toModel(Veiculo veiculo){
        return modelMapper.map(veiculo, VeiculoRepresentationModel.class);
    }

    public List<VeiculoRepresentationModel> toCollectionModel(List<Veiculo> veiculos){
        return veiculos.stream()
                .map(this::toModel)
                .toList();
    }

}
