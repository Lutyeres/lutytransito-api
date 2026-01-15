package com.lutyeres.lutytransito.api.controller;

import com.lutyeres.lutytransito.domain.model.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping("/proprietarios")
    public List<Proprietario> listar(){
        var p1 = new Proprietario();
        p1.setId(1L);
        p1.setNome("Savyo Lutyeres");
        p1.setEmail("savyo@lutyeres.dev");
        p1.setTelefone("62 9 9999-9999");

        var p2 = new Proprietario();
        p2.setId(2L);
        p2.setNome("Brunna Rafaella");
        p2.setEmail("brubs@gmail.com");
        p2.setTelefone("62 9 9999-8888");

        return Arrays.asList(p1,p2);
    }

}
