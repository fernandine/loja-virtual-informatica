import { HttpClient, HttpHeaders, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first, Observable, retry, map } from 'rxjs';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private readonly API = "http://localhost:8080/products";

  constructor(private httpClient: HttpClient) { }

  getProduct(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(this.API);
    
  };

  productById(id: number) {
    return this.httpClient.get<Product>(`${this.API}/${id}`);
  }
}
