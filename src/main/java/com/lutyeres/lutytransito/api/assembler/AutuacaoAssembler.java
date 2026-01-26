package com.lutyeres.lutytransito.api.assembler;


import com.lutyeres.lutytransito.api.model.AutuacaoRepresentationModel;
import com.lutyeres.lutytransito.api.model.input.AutuacaoInputRepresentationModel;
import com.lutyeres.lutytransito.domain.model.Autuacao;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.List;

@AllArgsConstructor
@Component
public class AutuacaoAssembler {

    private final ModelMapper modelMapper;

    public Autuacao toEntity(AutuacaoInputRepresentationModel autuacaoInputRepresentationModel){
        return modelMapper.map(autuacaoInputRepresentationModel, Autuacao.class);
    }

    public AutuacaoRepresentationModel toModel(Autuacao autuacao){
        return modelMapper.map(autuacao, AutuacaoRepresentationModel.class);
    }

    public List<AutuacaoRepresentationModel> toCollectionModel(List<Autuacao> autuacoes){
        return autuacoes.stream()
                .map(this::toModel).toList();
    }
}
