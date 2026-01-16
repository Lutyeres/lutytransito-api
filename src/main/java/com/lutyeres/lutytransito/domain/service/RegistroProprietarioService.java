package com.lutyeres.lutytransito.domain.service;


import com.lutyeres.lutytransito.domain.exception.NegocioExeception;
import com.lutyeres.lutytransito.domain.model.Proprietario;
import com.lutyeres.lutytransito.domain.repository.ProprietarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@AllArgsConstructor
public class RegistroProprietarioService {

    private final ProprietarioRepository proprietarioRepository;

    @Transactional
    public Proprietario salvar(Proprietario proprietario){
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail()).isPresent();

        if(emailEmUso){
            throw new NegocioExeception("Já existe um proprietario cadastrado com esse e-mail!");
        }
        return proprietarioRepository.save(proprietario);
    }

    public ResponseEntity<Proprietario> atualizar(Long id, Proprietario proprietario){

        if(!proprietarioRepository.existsById(id)){
            return  ResponseEntity.notFound().build();
        }
        boolean emailEmUso = proprietarioRepository.findByEmail(proprietario.getEmail()).filter(p -> !p.getId().equals(id) ).isPresent();
        if(emailEmUso){
            throw new NegocioExeception("Já existe um proprietario cadastrado com esse e-mail!");
        }
        proprietario.setId(id);
        Proprietario proprietarioAtualizado = proprietarioRepository.save(proprietario);
        return ResponseEntity.ok(proprietarioAtualizado);

    }

    @Transactional
    public ResponseEntity deletar(Long id){

        if(!proprietarioRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        proprietarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
