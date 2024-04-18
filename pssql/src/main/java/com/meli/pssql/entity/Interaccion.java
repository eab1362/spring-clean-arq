package com.meli.pssql.entity;

import com.meli.pssql.utils.InteractionType;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("interacciones")
public class Interaccion {

    @Id
    private Long interactionId;

    @Column("case_id")
    private String caseId;

    @Column("interaction_type")
    private String interactionType;

    @Column("representante")
    private String representante;

    @Column("int_date")
    private LocalDateTime intDate;

    // Getters y setters...
}