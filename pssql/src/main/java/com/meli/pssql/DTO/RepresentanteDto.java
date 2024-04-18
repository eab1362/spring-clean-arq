package com.meli.pssql.DTO;

import com.meli.pssql.entity.Representante;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;


@Data
@NoArgsConstructor
public class RepresentanteDto implements Serializable{

    private String name;
    private String team;


    public RepresentanteDto(Representante representante) {
        this.name = representante.getFullName();
        this.team = representante.getTeam();


    }
}