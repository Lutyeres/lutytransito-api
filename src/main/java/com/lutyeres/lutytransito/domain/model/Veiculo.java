package com.lutyeres.lutytransito.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @Valid
    @ManyToOne
    @JoinColumn(name = "propId")
    @NotNull
    private Proprietario proprietario;

    @NotBlank
    @Size(max = 20)
    private String veicMarca;

    @NotBlank
    @Size(max = 20)
    private String veicModelo;

    @NotBlank
    @Size(max =7)
    @Pattern(regexp = "[A-Z]{3}[0-9][0-9A-Z][0-9]{2}") //XXX0000 or XXX0X00
    private String veicPlaca;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime veicDataApreensao;

    @JsonProperty(access = Access.READ_ONLY)
    private LocalDateTime veicDataCadastro;

    @JsonProperty(access = Access.READ_ONLY)
    @Enumerated(EnumType.STRING)
    private StatusVeiculo veicStatus;
}
