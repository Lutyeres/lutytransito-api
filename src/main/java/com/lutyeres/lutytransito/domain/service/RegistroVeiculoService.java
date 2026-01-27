package com.lutyeres.lutytransito.domain.service;

import com.lutyeres.lutytransito.domain.exception.EntidadeNaoEncontradaException;
import com.lutyeres.lutytransito.domain.exception.NegocioExeception;
import com.lutyeres.lutytransito.domain.model.Proprietario;
import com.lutyeres.lutytransito.domain.model.StatusVeiculo;
import com.lutyeres.lutytransito.domain.model.Veiculo;
import com.lutyeres.lutytransito.domain.repository.VeiculoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RegistroVeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final RegistroProprietarioService registroProprietarioService;

    @Transactional
    public Veiculo salvar(Veiculo novoVeiculo){
        boolean placaEmUso = veiculoRepository.findByVeicPlaca(novoVeiculo.getVeicPlaca()).isPresent();

        if(placaEmUso){
            throw new NegocioExeception("A placa já está em uso por outro veículo!");
        }
        Proprietario proprietario = registroProprietarioService.buscar(novoVeiculo.getProprietario().getId());
        novoVeiculo.setProprietario(proprietario);
        novoVeiculo.setVeicStatus(StatusVeiculo.REGULAR);
        novoVeiculo.setVeicDataCadastro(OffsetDateTime.now());
        return veiculoRepository.save(novoVeiculo);
    }

    @Transactional
    public ResponseEntity<Veiculo> atualizar (Long id, Veiculo veiculo){

        if(!veiculoRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        boolean placaEmUso = veiculoRepository.findByVeicPlaca(veiculo.getVeicPlaca()).filter(v -> !v.getVeicID().equals(id)).isPresent();
        if(placaEmUso){
            throw new NegocioExeception("A placa já está em uso por outro veículo!");
        }
        Proprietario proprietario = registroProprietarioService.buscar(veiculo.getProprietario().getId());

        Optional<Veiculo> veiculoDB = veiculoRepository.findById(id);
        veiculo.setVeicID(id);
        veiculo.setVeicDataCadastro(veiculoDB.get().getVeicDataCadastro());
        Veiculo veiculoAtualizado = veiculoRepository.save(veiculo);
        return ResponseEntity.ok(veiculoAtualizado);
    }


    public Veiculo buscar(Long veiculoId){
        return veiculoRepository.findById(veiculoId).orElseThrow(() -> new EntidadeNaoEncontradaException("Veículo não encontrado!"));
    }


}
