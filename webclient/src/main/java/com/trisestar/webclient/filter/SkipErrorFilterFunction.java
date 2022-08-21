package com.trisestar.webclient.filter;

import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import reactor.core.publisher.Mono;

public class SkipErrorFilterFunction implements ExchangeFilterFunction {

    @Override
    public Mono<ClientResponse> filter( ClientRequest request, ExchangeFunction next) {
        return next.exchange(request).flatMap(res -> {
            if (res.rawStatusCode() >= 300) {
                res = res.mutate()
                        .header("original-status", String.valueOf(res.rawStatusCode()))
                        .rawStatusCode(200)
                        .build();
            }
            return Mono.just(res);
        });
    }
}
