package com.meli.pssql.utils;

public enum InteractionType {

    USER_CONTACT,
    REP_RESPONSE,
    USER_RECONTACT,
    REP_DERIVATION,
    REP_CASE_CLOSED,
    SURVEY_SENT;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
