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
  isEditing: boolean = false;

  constructor(private formBuilder : FormBuilder,
              private service : ContatoService){
                this.formGroupContact = formBuilder.group({
                  id : [''],
                  name : [''],
                  email : [''],
                  sex : [''],
                  choose : [''],
                  phone : [''],
                  speci : [false],
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
    if (this.isEditing) {
      this.service.update(this.formGroupContact.value).subscribe({
        next : () => {
          this.loadContacts();
          this.isEditing = false;
        }
      })
    }
    else{
      this.service.save(this.formGroupContact.value).subscribe({
        next : (data: Contact) => this.contacts.push(data)
      });
    }
    this.formGroupContact.reset();
  }
  delete(contact : Contact) {
    this.service.delete(contact).subscribe({
      next : () => this.loadContacts()
    })
    }
   edit(contact : Contact){
    this.formGroupContact.setValue(contact);
    this.isEditing = true;
   } 
}
