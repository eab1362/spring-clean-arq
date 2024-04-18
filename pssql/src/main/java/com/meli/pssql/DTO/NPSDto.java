package com.meli.pssql.DTO;

import com.meli.pssql.entity.NPS;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class NPSDto implements Serializable {
    private Long id;
    private Integer score;

    public NPSDto(NPS nps) {
        this.id = nps.getCaseId();
        this.score = nps.getNpsScore();
    }

}
