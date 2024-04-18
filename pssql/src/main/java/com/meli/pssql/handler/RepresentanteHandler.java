package com.meli.pssql.handler;

import com.meli.pssql.DTO.RepresentanteDto;
import com.meli.pssql.entity.Representante;
import com.meli.pssql.services.RepresentanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class RepresentanteHandler {

    @Autowired
    private RepresentanteService representanteService;

    public Mono<ServerResponse> getAllRepresentantes(ServerRequest request) {
        return ok().contentType(APPLICATION_JSON)
                .body(fromPublisher(representanteService.getAllRepresentantes(), RepresentanteDto.class));
    }

    public Mono<ServerResponse> getRepresentanteById(ServerRequest request) {
        return representanteService.getRepresentanteById(request.pathVariable("id"))
                .flatMap(representante -> ok().contentType(APPLICATION_JSON)
                        .bodyValue(representante));
    }

}