package webclient.controller;


import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class SecurityController {


    @GetMapping("/")
    public Mono<String> index(@AuthenticationPrincipal Mono<OAuth2User> oauth2User) {
        return oauth2User
                .flatMap(user -> Mono.just("Hi, " + user.getAttribute("given_name")));
    }

}
