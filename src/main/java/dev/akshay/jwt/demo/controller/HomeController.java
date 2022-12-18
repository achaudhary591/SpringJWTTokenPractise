package dev.akshay.jwt.demo.controller;

import com.nimbusds.jwt.JWT;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HomeController {

    @GetMapping("")
    public String home(Principal principal){
        return "Hello "+principal.getName()+" this is an JWT API";
    }
}
