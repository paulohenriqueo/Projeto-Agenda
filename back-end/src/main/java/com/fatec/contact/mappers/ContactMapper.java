package com.fatec.contact.mappers;

import com.fatec.contact.dto.ContactRequest;
import com.fatec.contact.dto.ContactResponse;
import com.fatec.contact.entities.Contact;

public class ContactMapper {
    
    public static Contact toEntity(ContactRequest request){
        
        Contact contact = new Contact();
        contact.setName(request.name());
        contact.setEmail(request.email());
        contact.setSex(request.sex());
        contact.setChoose(request.choose());
        contact.setPhone(request.phone());
        contact.setSpeci(request.speci());

        return contact;
    }

    public static ContactResponse toDTO(Contact contact){
        return new ContactResponse(contact.getId(), contact.getName(), contact.getEmail(), 
        contact.getSex(), contact.getChoose(), contact.getPhone(), contact.getSpeci());
    }

}
