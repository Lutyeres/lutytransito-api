package com.lutyeres.lutytransito.domain.model;

import com.lutyeres.lutytransito.domain.exception.NegocioExeception;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = false)
@Entity
public class Veiculo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long veicID;

    @ManyToOne
    @JoinColumn(name = "propId")
    private Proprietario proprietario;

    private String veicMarca;
    private String veicModelo;
    private String veicPlaca;
    private OffsetDateTime veicDataApreensao;
    private OffsetDateTime veicDataCadastro;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo veicStatus;

    @OneToMany(mappedBy = "veiculo", cascade = CascadeType.ALL)
    private List<Autuacao> autuacoes = new ArrayList<>();

    public Autuacao adicionarAutuacao(Autuacao autuacao){
        autuacao.setDataOcorrencia(OffsetDateTime.now());
        autuacao.setVeiculo(this);
        getAutuacoes().add(autuacao);
        return autuacao;
    }

    public void apreender(){
        if(estaApreendido()){
            throw new NegocioExeception("Veículo já se encontra apreendido!");
        }

        setVeicStatus(StatusVeiculo.APREENDIDO);
        setVeicDataApreensao(OffsetDateTime.now());
    }

    public void removerApreensao(){
        if(naoEstaApreendido()){
            throw new NegocioExeception("Veículo não está apreendido!");
        }

        setVeicStatus(StatusVeiculo.REGULAR);
        setVeicDataApreensao(null);
    }

    public boolean estaApreendido(){
        return StatusVeiculo.APREENDIDO.equals(getVeicStatus());
    }

    public boolean naoEstaApreendido(){
        return !estaApreendido();
    }

}
