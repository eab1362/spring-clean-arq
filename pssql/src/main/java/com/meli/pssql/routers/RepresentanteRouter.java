package com.meli.pssql.routers;

import com.meli.pssql.handler.RepresentanteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class RepresentanteRouter {

    @Bean
    public RouterFunction<ServerResponse> route(RepresentanteHandler handler) {
        return RouterFunctions.route(GET("/api/representantes"), handler::getAllRepresentantes)
                .andRoute(GET("/api/representantes/{id}"), handler::getRepresentanteById);
        // Agrega otras rutas según sea necesario
    }

}