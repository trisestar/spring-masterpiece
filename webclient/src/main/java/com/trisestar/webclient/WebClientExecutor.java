package com.trisestar.webclient;

import com.trisestar.webclient.filter.SkipErrorFilterFunction;
import com.trisestar.webclient.model.RequestModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.lang.invoke.MethodHandles;

@Component
public class WebClientExecutor {

    private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final WebClient.Builder externalWebclient;
    private final WebClient.Builder internalWebclient;

    public WebClientExecutor(@Qualifier("externalWebclient") WebClient.Builder externalWebclient,
                             @Qualifier("internalWebclient") WebClient.Builder internalWebclient) {
        this.externalWebclient = externalWebclient;
        this.internalWebclient = internalWebclient;
    }

    public Mono<ResponseEntity<Object>> execute(RequestModel requestModel) {
        WebClient.Builder webclientBuilder = requestModel.isInternal() ? internalWebclient : externalWebclient;

        return webclientBuilder
                .filter((request, next) -> new SkipErrorFilterFunction().filter(request, next))
                .baseUrl(requestModel.getUri())
                .build()
                .method(HttpMethod.valueOf(requestModel.getMethod().toUpperCase()))
                .body(Mono.justOrEmpty(requestModel.getBody()), Object.class)
                .retrieve()
                .toEntity(Object.class)
                .flatMap(objectResponseEntity -> {
                    logger.info(objectResponseEntity.toString());
                    return Mono.just(objectResponseEntity);
                });
    }
}
