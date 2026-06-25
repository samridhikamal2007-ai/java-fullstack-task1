package com.maincrafts.internship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private static final Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);

    private final ContactRepository repo;

    public ContactServiceImpl(ContactRepository repo) {
        this.repo = repo;
    }

    @Override
    public Contact saveContact(ContactDTO dto) {
        logger.info("=========================================");
        logger.info("Processing inbound submission form payload:");
        logger.info("Captured Name: {}", dto.getName());
        logger.info("Captured Email: {}", dto.getEmail());
        logger.info("Captured Message: {}", dto.getMessage());
        logger.info("=========================================");

        Contact contact = new Contact();
        contact.setName(dto.getName());
        contact.setEmail(dto.getEmail());
        contact.setMessage(dto.getMessage());

        return repo.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        logger.info("Executing retrieval sweep for all contact submissions.");
        return repo.findAll();
    }
}
