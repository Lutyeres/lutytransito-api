package com.lutyeres.lutytransito.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProprietarioIdInputRepresentationModel {

    @NotNull
    private Long id;
}
