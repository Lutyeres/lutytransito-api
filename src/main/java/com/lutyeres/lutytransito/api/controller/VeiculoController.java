package com.lutyeres.lutytransito.api.controller;

import com.lutyeres.lutytransito.domain.exception.NegocioExeception;
import com.lutyeres.lutytransito.domain.model.Veiculo;
import com.lutyeres.lutytransito.domain.repository.VeiculoRepository;
import com.lutyeres.lutytransito.domain.service.RegistroVeiculoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoRepository veiculoRepository;
    private final RegistroVeiculoService registroVeiculoService;

    @GetMapping
    public List<Veiculo> listar(){
        return veiculoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscar(@PathVariable Long id){
        return veiculoRepository.findById(id)
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

    @ExceptionHandler
    public ResponseEntity<String> capturar(NegocioExeception e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
