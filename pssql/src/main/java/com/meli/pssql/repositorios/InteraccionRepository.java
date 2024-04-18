package com.meli.pssql.repositorios;

import com.meli.pssql.entity.Interaccion;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteraccionRepository extends ReactiveCrudRepository<Interaccion, Long> {
}
