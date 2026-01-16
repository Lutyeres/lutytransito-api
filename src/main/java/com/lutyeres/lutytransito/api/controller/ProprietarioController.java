package com.lutyeres.lutytransito.api.controller;

import com.lutyeres.lutytransito.domain.model.Proprietario;
import com.lutyeres.lutytransito.domain.repository.ProprietarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/proprietarios")
public class ProprietarioController {


    private final ProprietarioRepository proprietarioRepository;

    @GetMapping
    public List<Proprietario> listar(){

        return proprietarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proprietario> buscar(@PathVariable Long id){
        return proprietarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Proprietario adicionar(@Valid @RequestBody Proprietario proprietario){
        return proprietarioRepository.save(proprietario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proprietario> atualizar(@PathVariable Long id,
                                                  @RequestBody Proprietario proprietario){

        if(!proprietarioRepository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }
        proprietario.setId(id);
        Proprietario proprietarioAtualizado = proprietarioRepository.save(proprietario);
        return ResponseEntity.ok(proprietarioAtualizado);


    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id){

        if(!proprietarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        proprietarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
