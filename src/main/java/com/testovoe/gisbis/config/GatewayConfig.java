package com.testovoe.gisbis.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;

@Configuration
public class GatewayConfig {

    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder locatorBuilder){
        return locatorBuilder
                .routes()
                .route(firstRoute -> firstRoute
                        .path("/render-data/**")
                        .and()
                        .method(HttpMethod.GET)
                        .filters(filter -> filter
                                        .stripPrefix(1)
                                ).uri("lb://render"))
                .build();
    }
}
