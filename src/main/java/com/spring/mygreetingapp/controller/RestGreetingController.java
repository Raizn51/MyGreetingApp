package com.spring.mygreetingapp.controller;

import com.spring.mygreetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class RestGreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public String getGreeting() {
        return greetingService.getGreetingMessage();
    }

    @PostMapping
    public String postGreeting() {
        return "{\"message\": \"Hello from POST!\"}";
    }

    @PutMapping
    public String putGreeting() {
        return "{\"message\": \"Hello from PUT!\"}";
    }

    @DeleteMapping
    public String deleteGreeting() {
        return "{\"message\": \"Hello from DELETE!\"}";
    }
}