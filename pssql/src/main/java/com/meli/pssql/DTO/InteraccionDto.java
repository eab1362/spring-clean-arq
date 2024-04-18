package com.meli.pssql.DTO;

import com.meli.pssql.entity.Interaccion;
import com.meli.pssql.repositorios.InteraccionRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.text.SimpleDateFormat;

@Data
@NoArgsConstructor
public class InteraccionDto implements Serializable {

    private Long id;
    private String interaction_type;
    private String fecha;


    public InteraccionDto(Interaccion interaccion) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.id = interaccion.getInteractionId();
        this.interaction_type = interaccion.getInteractionType();
        this.fecha = sdf.format(interaccion.getIntDate()); // Formatea la fecha a String
    }



}
