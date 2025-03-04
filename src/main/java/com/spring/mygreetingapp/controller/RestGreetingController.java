package com.spring.mygreetingapp.controller;

import com.spring.mygreetingapp.model.Greeting;
import com.spring.mygreetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class RestGreetingController {

    @Autowired
    private GreetingService greetingService;


    @GetMapping
    public String getGreeting(@RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName) {
        return greetingService.getGreetingMessage(firstName, lastName);
    }


    @PostMapping
    public Greeting createGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
    }

    @GetMapping("/{id}")
    public Greeting getGreeting(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
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