package com.spring.mygreetingapp.controller;

import com.spring.mygreetingapp.model.Greeting;
import com.spring.mygreetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getGreetingById(@PathVariable Long id) {
        Greeting greeting = greetingService.getGreetingById(id);
        return greeting != null ? ResponseEntity.ok(greeting) : ResponseEntity.ok("Greeting not Found");
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllGreetings() {
        List<?> greetings = greetingService.getAllGreetings();
        return greetings.isEmpty() ? ResponseEntity.ok("Greeting not Found") : ResponseEntity.ok(greetings);
    }

    @PostMapping
    public Greeting createGreeting(@RequestParam String message) {
        return greetingService.saveGreeting(message);
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