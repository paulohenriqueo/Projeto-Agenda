import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Contato } from './contato';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContatoService {

  constructor(private http: HttpClient) { }


}
