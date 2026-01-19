package com.lutyeres.lutytransito.domain.model;

import com.lutyeres.lutytransito.domain.validation.ValidationGroups;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity //Mapeamento do Objeto Relacional com o Banco de dados
public class Proprietario {

    @NotNull(groups = ValidationGroups.ProprietarioId.class)
    @EqualsAndHashCode.Include //Anotação para incluir o ID no Equals and HashCode
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propId")
    private Long id;

    @NotBlank
    @Size(max = 60)
    @Column(name = "propNome")
    private String nome;

    @NotBlank
    @Size(max = 225)
    @Email
    @Column(name = "propEmail")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "propTelefone")
    private String telefone;


}
