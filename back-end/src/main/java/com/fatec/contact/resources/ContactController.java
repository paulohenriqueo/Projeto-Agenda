package com.fatec.contact.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.contact.entities.Contact;
import com.fatec.contact.resources.services.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getContacts(){

        return contactService.getContacts();
    }

}
