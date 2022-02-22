package com.niit.com.api_gateway_server.configurations;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator applicationRoutes(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                .route( p -> p
                        .path("/api/storyManagement/**")
                        .uri("http://localhost:8080")
                )
                .build();
    }
}
