package dev.akshay.jwt.demo.controller;

import dev.akshay.jwt.demo.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    public String token(Authentication authentication){
        LOG.debug("Token Requested for user: '{}'", authentication.getName());
        String token = tokenService.generatedToken(authentication);
        LOG.debug("Token Granted {}", token);
        return token;
    }
}
