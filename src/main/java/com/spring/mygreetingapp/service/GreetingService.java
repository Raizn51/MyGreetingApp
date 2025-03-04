package com.spring.mygreetingapp.service;

import com.spring.mygreetingapp.model.Greeting;
import com.spring.mygreetingapp.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GreetingService
{
    @Autowired
    private GreetingRepository greetingRepository;

    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    public Greeting saveGreeting(String message) {
        Greeting greeting = new Greeting(message);
        return greetingRepository.save(greeting);
    }

    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElse(null);
    }


    public String getGreetingMessage(String firstName, String lastName) {
        if (firstName != null && lastName != null) {
            return "{\"message\": \"Hello " + firstName + " " + lastName + "\"}";
        } else if (firstName != null) {
            return "{\"message\": \"Hello " + firstName + "\"}";
        } else if (lastName != null) {
            return "{\"message\": \"Hello " + lastName + "\"}";
        } else {
            return "{\"message\": \"Hello World\"}";
        }
    }

    public Greeting updateGreeting(Long id, String newMessage) {
        Optional<Greeting> optionalGreeting = greetingRepository.findById(id);
        if (optionalGreeting.isPresent()) {
            Greeting greeting = optionalGreeting.get();
            greeting.setMessage(newMessage);
            return greetingRepository.save(greeting);
        }
        return null;
    }

}
