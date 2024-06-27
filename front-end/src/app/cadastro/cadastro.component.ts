import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ContatoService } from '../contato.service';
import { Contact} from '../contact';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css'
})
export class CadastroComponent implements OnInit {

  contacts: Contact[] = [];
  formGroupContact : FormGroup;

  constructor(private formBuilder : FormBuilder,
              private service : ContatoService){
                this.formGroupContact = formBuilder.group({
                  id : [''],
                  name : [''],
                  email : [''],
                  sex : [''],
                  choose : [''],
                  phone : [''],
                  speci : [''],
                })
              }
  
  ngOnInit(): void {
    this.loadContacts();
  }

  loadContacts() {
    this.service.getContacts().subscribe({
      next : data => this.contacts = data
    });
  }

  save(){
    this.service.save(this.formGroupContact.value).subscribe({
      next : data => this.contacts.push(data)
    })
  }
}
