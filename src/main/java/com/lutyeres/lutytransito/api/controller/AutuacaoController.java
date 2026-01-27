package com.lutyeres.lutytransito.api.controller;


import com.lutyeres.lutytransito.api.assembler.AutuacaoAssembler;
import com.lutyeres.lutytransito.api.model.AutuacaoRepresentationModel;
import com.lutyeres.lutytransito.api.model.input.AutuacaoInputRepresentationModel;
import com.lutyeres.lutytransito.domain.model.Autuacao;
import com.lutyeres.lutytransito.domain.model.Veiculo;
import com.lutyeres.lutytransito.domain.service.RegistroAutuacaoService;
import com.lutyeres.lutytransito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/veiculos/{veiculoId}/autuacoes")
public class AutuacaoController {

    private AutuacaoAssembler autuacaoAssembler;
    private RegistroAutuacaoService registroAutuacaoService;
    private final RegistroVeiculoService registroVeiculoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AutuacaoRepresentationModel registrar(@PathVariable Long veiculoId,
                                                 @Valid @RequestBody AutuacaoInputRepresentationModel autuacaoInputRepresentationModel){
        Autuacao novaAutuacao = autuacaoAssembler.toEntity(autuacaoInputRepresentationModel);
        Autuacao autuacaoRegistrada = registroAutuacaoService.registrar(veiculoId, novaAutuacao);

        return autuacaoAssembler.toModel(autuacaoRegistrada);
    }

    @GetMapping
    public List<AutuacaoRepresentationModel> listar(@PathVariable Long veiculoId){
        Veiculo veiculo = registroVeiculoService.buscar(veiculoId);
        return autuacaoAssembler.toCollectionModel(veiculo.getAutuacoes());
    }

}
