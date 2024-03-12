package org.sii.authentification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.HandlerFunction;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

import static org.springframework.web.servlet.function.RequestPredicates.path;

@Configuration
public class RouteConfiguration {

    @Bean
    public RouterFunction<ServerResponse> route() {
        return RouterFunctions
                .route()
                .nest(path("/api"),
                        builder -> builder
                                .nest(path("/absence"),
                                        absenceBuilder -> absenceBuilder
                                                .GET("/**", handleAbsenceRequest())
                                )
                                .nest(path("/administrativeDocument"),
                                        adminDocBuilder -> adminDocBuilder
                                                .GET("/**", handleAdminDocumentRequest())
                                )
                                .nest(path("/resource"),
                                        adminDocBuilder -> adminDocBuilder
                                                .GET("/**", handleResourceRequest())
                                )
                )
                .build();
    }



    private HandlerFunction<ServerResponse> handleAbsenceRequest() {
        return request -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8082")).build();
    }

    private HandlerFunction<ServerResponse> handleAdminDocumentRequest() {

        return request -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8083")).build();
    }
    private HandlerFunction<ServerResponse> handleResourceRequest() {
        return request -> ServerResponse.temporaryRedirect(URI.create("http://localhost:8084")).build();

    }
}
