package com.lutyeres.lutytransito.domain.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity //Mapeamento do Objeto Relacional com o Banco de dados
public class Proprietario {

    @EqualsAndHashCode.Include //Anotação para incluir o ID no Equals and HashCode
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propId")
    private Long id;

    @Column(name = "propNome")
    private String nome;

    @Column(name = "propEmail")
    private String email;

    @Column(name = "propTelefone")
    private String telefone;


}
