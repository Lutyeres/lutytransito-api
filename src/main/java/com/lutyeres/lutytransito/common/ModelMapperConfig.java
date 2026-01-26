package com.lutyeres.lutytransito.common;

import com.lutyeres.lutytransito.api.assembler.VeiculoAssembler;
import com.lutyeres.lutytransito.api.model.input.VeiculoInputRepresentationModel;
import com.lutyeres.lutytransito.domain.model.Veiculo;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();

        modelMapper.createTypeMap(VeiculoInputRepresentationModel.class, Veiculo.class)
                .addMapping(VeiculoInputRepresentationModel::getMarca, Veiculo::setVeicMarca)
                .addMapping(VeiculoInputRepresentationModel::getModelo, Veiculo::setVeicModelo)
                .addMapping(VeiculoInputRepresentationModel::getPlaca, Veiculo::setVeicPlaca);

//        modelMapper.createTypeMap(Veiculo.class, VeiculoInputRepresentationModel.class)
//                .addMappings(mapper -> mapper.map(Veiculo::getVeicModelo, VeiculoInputRepresentationModel::setModelo));

        return modelMapper;
    }

}
