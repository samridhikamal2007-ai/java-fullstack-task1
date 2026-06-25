package com.maincrafts.internship;

import java.util.List;

public interface ContactService {
    Contact saveContact(ContactDTO contactDTO);

    List<Contact> getAllContacts();
}
