package com.lutyeres.lutytransito.api.controller;

import com.lutyeres.lutytransito.api.model.VeiculoRepresentationModel;
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
    private final ModelMapper modelMapper;

    @GetMapping
    public List<VeiculoRepresentationModel> listar(){
        return veiculoRepository.findAll().stream().map(veiculo -> modelMapper.map(veiculo, VeiculoRepresentationModel.class)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoRepresentationModel> buscar(@PathVariable Long id){
        return veiculoRepository.findById(id)
                .map(veiculo -> modelMapper.map(veiculo, VeiculoRepresentationModel.class))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo adicionar(@Valid @RequestBody Veiculo veiculo){
        return registroVeiculoService.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable Long id,@RequestBody Veiculo veiculo){
        return registroVeiculoService.atualizar(id, veiculo);
    }
}
