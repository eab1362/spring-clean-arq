package com.meli.pssql.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("representantes")
public class Representante {

    @Id
    @Column("representante")
    private String representanteId;

    @Column("full_name")
    private String fullName;

    @Column("team")
    private String team;

    @Column("incoming_date")
    private LocalDate incomingDate;

    @Column("status")
    private String status;
}
