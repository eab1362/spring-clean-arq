package com.meli.pssql.repositorios;

import org.springframework.stereotype.Repository;
import com.meli.pssql.entity.Representante;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

@Repository
public interface RepresentanteRepository extends ReactiveCrudRepository<Representante, String> {
    Flux<Representante> findAll();
}