import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contact } from './contact';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {

  url = "http://localhost:8080/contacts"

  constructor(private http: HttpClient) { }

  getContacts() : Observable<Contact[]>{
    return this.http.get<Contact[]>(this.url);
  }

  save(contact : Contact): Observable<Contact>{
    return this.http.post<Contact>(this.url, contact);
  }

  delete(contact: Contact): Observable<void>{
    return this.http.delete<void>(`${this.url}/${contact.id}`)
  }

}
