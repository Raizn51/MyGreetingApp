package com.spring.mygreetingapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService
{
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
}
