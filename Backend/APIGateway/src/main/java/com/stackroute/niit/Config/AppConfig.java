package com.stackroute.niit.Config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p-> p
						.path("/api/stcontrol/**")
						.uri("http://localhost:8088"))
				.route(p->p
						.path("/auth/**")
						.uri("http://localhost:8087"))
				.build();
				
	}

}
