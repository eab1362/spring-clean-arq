package com.meli.pssql.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;

import lombok.Data;

import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("nps")
public class NPS {

    @Id
    private Long surveyId;

    @Column("case_id")
    private Long caseId;

    @Column("nps_score")
    private Integer npsScore;

    @Column("nps_comment")
    private String npsComment;

    // Getters, setters, and constructors
}
