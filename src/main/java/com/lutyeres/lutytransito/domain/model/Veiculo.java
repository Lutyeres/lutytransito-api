package com.lutyeres.lutytransito.domain.model;

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
}
