package com.maincrafts.internship;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController // [cite: 36]
@CrossOrigin(origins = "*") 
public class ContactController { // [cite: 37]

    @PostMapping("/contact") // [cite: 38]
    public String handleContact( // [cite: 39]
            @RequestParam String name, // [cite: 39]
            @RequestParam String email, // [cite: 42]
            @RequestParam String message) { // [cite: 43]
        
        System.out.println("====== New Contact Form Submission ======");
        System.out.println("Name   : " + name); // [cite: 44]
        System.out.println("Email  : " + email); // [cite: 44]
        System.out.println("Message: " + message); // [cite: 44]
        System.out.println("=========================================");
        
        return "Form submitted successfully!"; // [cite: 44]
    }
}