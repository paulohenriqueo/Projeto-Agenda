package com.fatec.contact.resources.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void update(int id, Contact contact){
        try{
            Contact aux = contactRepository.getReferenceById(id);
            aux.setName(contact.getName());
            aux.setEmail(contact.getEmail());
            aux.setSex(contact.getSex());
            aux.setChoose(contact.getChoose());
            aux.setPhone(contact.getPhone());
            aux.setSpeci(contact.getSpeci());
            this.contactRepository.save(aux);
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Contato não encontrado");
        }
    }

}
