package com.lutyeres.lutytransito.api.controller;

import com.lutyeres.lutytransito.api.assembler.VeiculoAssembler;
import com.lutyeres.lutytransito.api.model.VeiculoRepresentationModel;
import com.lutyeres.lutytransito.api.model.input.VeiculoInputRepresentationModel;
import com.lutyeres.lutytransito.domain.exception.NegocioExeception;
import com.lutyeres.lutytransito.domain.model.Veiculo;
import com.lutyeres.lutytransito.domain.repository.VeiculoRepository;
import com.lutyeres.lutytransito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/veiculos")
public class  VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;
    private final VeiculoAssembler veiculoAssembler;

    @GetMapping
    public List<VeiculoRepresentationModel> listar(){
        return veiculoAssembler.toCollectionModel(veiculoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoRepresentationModel> buscar(@PathVariable Long id){
        return veiculoRepository.findById(id)
                .map(veiculoAssembler::toModel)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VeiculoRepresentationModel adicionar(@Valid @RequestBody VeiculoInputRepresentationModel veiculoInputRepresentationModel){
        Veiculo novoVeiculo = veiculoAssembler.toEntity(veiculoInputRepresentationModel);
        Veiculo veiculoCadastrado = registroVeiculoService.salvar(novoVeiculo);

        return veiculoAssembler.toModel(veiculoCadastrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id,@RequestBody Veiculo veiculo){
        return registroVeiculoService.atualizar(id, veiculo);
    }
}
