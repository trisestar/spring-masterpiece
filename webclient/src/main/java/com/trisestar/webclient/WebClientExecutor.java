package com.trisestar.webclient;

import com.trisestar.webclient.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class WebClientExecutor {


    private final WebClient.Builder webclient;

    @Autowired
    public WebClientExecutor(WebClient.Builder webclient) {
        this.webclient = webclient;
    }

    public Object execute(RequestModel requestModel) {
        return webclient.baseUrl(requestModel.getUri())
                .build()
                .method(HttpMethod.valueOf(requestModel.getMethod().toUpperCase()))
                .body(Mono.justOrEmpty(requestModel.getBody()), Object.class)
                .retrieve()
                .bodyToMono(Object.class);
    }
}
