package com.lutyeres.lutytransito.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @NotBlank
    @Size(max = 20)
    private String veicMarca;

    @NotBlank
    @Size(max = 20)
    private String veicModelo;

    @NotBlank
    @Size(max =7)
    private String veicPlaca;


    private LocalDateTime veicDataApreensao;

    @NotNull
    private LocalDateTime veicDataCadastro;

    @Enumerated(EnumType.STRING)
    private StatusVeiculo veicStatus;
}
