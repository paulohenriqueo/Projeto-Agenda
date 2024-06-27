package com.fatec.contact.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.contact.dto.ContactResponse;
import com.fatec.contact.entities.Contact;
import com.fatec.contact.resources.services.ContactService;

@RestController
@RequestMapping("contact")
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getContats(){
        return ResponseEntity.ok(contactService.getContacts());
    }

    @GetMapping("{id}")
    public Contact getContactById(@PathVariable int id){
        return contactService.getContactById(id);
    }
}
