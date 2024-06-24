package com.fatec.contact.resources;

import java.util.ArrayList;
import java.util.List;;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.contact.entities.Contact;

@RestController
@RequestMapping("contact")
public class ContactController {
    
    @GetMapping
    public List<Contact> getContacts(){

        Contact c1 = new Contact();
        c1.setId(1);
        c1.setName("Paulo");
        c1.setEmail("paulohenrique@gmail.com");
        c1.setSex("Masculino");
        c1.setChoose(null);
        c1.setPhone("11943356247");

        Contact c2 = new Contact();
        c2.setId(2);
        c2.setName("Rodrigo");
        c2.setEmail("rodrigobrag@gmail.com");
        c2.setSex("Masculino");
        c2.setChoose(null);
        c2.setPhone("1199256327");

        ArrayList<Contact> lista = new ArrayList<Contact>();

        return lista;

    }

}
