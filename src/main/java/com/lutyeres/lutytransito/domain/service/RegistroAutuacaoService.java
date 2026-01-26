package com.lutyeres.lutytransito.domain.service;


import com.lutyeres.lutytransito.domain.model.Autuacao;
import com.lutyeres.lutytransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroAutuacaoService {

    private RegistroVeiculoService registroVeiculoService;

    @Transactional
    public Autuacao registrar(Long veiculoId,Autuacao novaAutuacao){
        Veiculo veiculo = registroVeiculoService.buscar(veiculoId);

        return veiculo.adicionarAutuacao(novaAutuacao);
    }

}
