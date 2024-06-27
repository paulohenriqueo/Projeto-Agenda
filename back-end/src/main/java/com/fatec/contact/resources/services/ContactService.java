package com.fatec.contact.resources.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.contact.dto.ContactRequest;
import com.fatec.contact.dto.ContactResponse;
import com.fatec.contact.entities.Contact;
import com.fatec.contact.mappers.ContactMapper;
import com.fatec.contact.repositories.ContactRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;

    public List<ContactResponse> getContacts(){

        List <Contact> contacts = contactRepository.findAll();

        return contacts.stream().map(c -> ContactMapper.toDTO(c))
                                .collect(Collectors.toList());

    }

    public Contact getContactById(int id){
        return contactRepository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Contato não encontrado")
        );
    }

    public Contact save(Contact contact){
        return this.contactRepository.save(contact);
    }

    public void deleteContactById(int id){
        if (this.contactRepository.existsById(id)) {
            this.contactRepository.deleteById(id);
        }
        else{
            throw new EntityNotFoundException("Contato não Cadastrado");
        }
    }

    public void update(int id, ContactRequest request){
        try{
            Contact aux = contactRepository.getReferenceById(id);
            aux.setName(request.name());
            aux.setEmail(request.email());
            aux.setSex(request.sex());
            aux.setChoose(request.choose());
            aux.setPhone(request.phone());
            aux.setSpeci(request.speci());
            this.contactRepository.save(aux);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Contato não encontrado");
        }
    }

}
