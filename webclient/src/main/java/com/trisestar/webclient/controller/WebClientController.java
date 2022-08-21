package com.trisestar.webclient.controller;

import com.trisestar.webclient.WebClientExecutor;
import com.trisestar.webclient.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class WebClientController {


    private final WebClientExecutor webClientExecutor;

    @Autowired
    public WebClientController(WebClientExecutor webClientExecutor) {
        this.webClientExecutor = webClientExecutor;
    }

    @PostMapping("/redirect")
    public Mono<ResponseEntity<Object>> redirect(@RequestBody RequestModel requestModel) {
        return webClientExecutor.execute(requestModel);
    }

    @PostMapping("/500")
    public Mono<ResponseEntity<Object>> error() {
        return Mono.just(ResponseEntity.status(500).body(Map.of("500", "500")));

    }

}
