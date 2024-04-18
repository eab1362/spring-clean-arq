package com.meli.pssql.services;

import com.meli.pssql.DTO.RepresentanteDto;
import com.meli.pssql.entity.Representante;
import com.meli.pssql.repositorios.InteraccionRepository;
import com.meli.pssql.repositorios.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class RepresentanteService {

    @Autowired
    private RepresentanteRepository representanteRepository;

    @Autowired
    private InteraccionRepository interaccionRepository;

    public Flux<RepresentanteDto> getAllRepresentantes() {
        return representanteRepository.findAll().
                map(RepresentanteDto::new);
    }

    @Transactional
    public Mono<Representante> saveRepresentante(Representante representante) {
        return representanteRepository.save(representante);
    }
    public Mono<Representante> getRepresentanteById(String id) {
        return representanteRepository.findById(id)
                .switchIfEmpty(Mono
                        .error(new RuntimeException("Representante no encontrado")));
    }
}