package com.trisestar.webclient.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    @Qualifier("externalWebclient")
    public WebClient.Builder externalWebClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    @Qualifier("internalWebclient")
    @LoadBalanced
    public WebClient.Builder internalWebClientBuilder() {
        return WebClient.builder();
    }
}
