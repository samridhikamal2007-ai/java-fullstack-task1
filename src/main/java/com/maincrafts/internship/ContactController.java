package com.maincrafts.internship;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "*") // Grants decoupled web browser contexts safety clearance
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    // Core endpoint handling inbound form pipelines
    @PostMapping("/submit")
    public ResponseEntity<Contact> saveContact(@Valid @RequestBody ContactDTO contactDTO) {
        Contact savedContact = contactService.saveContact(contactDTO);
        return new ResponseEntity<>(savedContact, HttpStatus.CREATED);
    }

    // Core endpoint outputting clean sequential JSON datasets
    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }
}