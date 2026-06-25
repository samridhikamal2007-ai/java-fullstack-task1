package com.maincrafts.internship;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactDTO {

    @NotBlank(message = "Name field cannot be left blank.")
    @Size(min = 2, max = 50, message = "Name must range between 2 and 50 characters.")
    private String name;

    @NotBlank(message = "Email field cannot be left blank.")
    @Email(message = "Please target a valid structurally sound email address.")
    private String email;

    @NotBlank(message = "Message context cannot be empty.")
    @Size(max = 1000, message = "Message scope maximum threshold is 1000 characters.")
    private String message;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}