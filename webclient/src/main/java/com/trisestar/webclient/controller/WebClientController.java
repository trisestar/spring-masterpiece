package com.trisestar.webclient.controller;

import com.trisestar.webclient.WebClientExecutor;
import com.trisestar.webclient.model.RequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebClientController {


    private final WebClientExecutor webClientExecutor;

    @Autowired
    public WebClientController(WebClientExecutor webClientExecutor) {
        this.webClientExecutor = webClientExecutor;
    }

    @PostMapping("/redirect")
    public Object redirect(@RequestBody RequestModel requestModel) {
        System.out.println(requestModel);
        return webClientExecutor.execute(requestModel);
    }


    @GetMapping("/")
    public Mono<String> index(@AuthenticationPrincipal Mono<OAuth2User> oauth2User) {
        return oauth2User
                .flatMap(user -> Mono.just("Hi, " + user.getAttribute("given_name")));
    }

}
