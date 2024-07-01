import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ContatoService } from '../contato.service';
import { Contact } from '../contact';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrl: './cadastro.component.css',
})
export class CadastroComponent implements OnInit {
  contacts: Contact[] = [];
  formGroupContact: FormGroup;
  isEditing: boolean = false;
  submited: boolean = false;

  constructor(
    private formBuilder: FormBuilder,
    private service: ContatoService
  ) {
    this.formGroupContact = formBuilder.group({
      id: [''],
      name: ['', [Validators.required, Validators.minLength(3)]],
      email: ['', [Validators.required]],
      sex: [''],
      choose: [''],
      phone: ['', [Validators.required, Validators.minLength(10)]],
      speci: [false],
    });
  }

  ngOnInit(): void {
    this.loadContacts();
  }

  loadContacts() {
    this.service.getContacts().subscribe({
      next: (data) => (this.contacts = data),
    });
  }

  save() {
    this.submited = true;

    if (this.formGroupContact.valid) {
      if (this.isEditing) {
        this.service.update(this.formGroupContact.value).subscribe({
          next: () => {
            this.loadContacts();
            this.isEditing = false;
          },
        });
      } else {

        if (this.formGroupContact.value.speci == true) {
          this.formGroupContact.patchValue({ speci : 'Profissional' })
        }
        else{
          this.formGroupContact.patchValue({ speci : 'Pessoal' })
        }

        this.service.save(this.formGroupContact.value).subscribe({
          next: (data) => {
            this.contacts.push(data);
            this.submited = false;
          },
        });
      }
    }

    this.formGroupContact.reset();
  }
  delete(contact: Contact) {
    this.service.delete(contact).subscribe({
      next: () => this.loadContacts(),
    });
  }
  edit(contact: Contact) {
    this.formGroupContact.setValue(contact);
    this.isEditing = true;
  }

  get name(): any {
    return this.formGroupContact.get('name');
  }
  get email(): any {
    return this.formGroupContact.get('email');
  }
  get phone(): any {
    return this.formGroupContact.get('phone');
  }
}
