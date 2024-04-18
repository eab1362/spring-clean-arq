package com.meli.pssql.repositorios;

import com.meli.pssql.entity.NPS;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NPSRepository extends ReactiveCrudRepository<NPS, Long> {
}
