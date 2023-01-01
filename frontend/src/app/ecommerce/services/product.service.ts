import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import {  map, Observable } from 'rxjs';
import { environment } from 'src/environment/environment';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  getProduct() {
    throw new Error('Method not implemented.');
  }
  private baseUrl = environment.shopApiUrl + '/products';
  private searchUrl = environment.shopApiUrl + '/products/search'

  constructor(private httpClient: HttpClient) { }

  getProductList(theCategoryId: number): Observable<Product[]> {

    const searchUrl = `${this.baseUrl}/search/category?id=${theCategoryId}`;
    return this.getProducts(searchUrl)
  }

  getProducts(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<ApiResponseProduct>(searchUrl)
      .pipe(map(response => response.content));
  }

  getProductListPaginate(
    thePage: number,
    thePageSize: number,
    theCategoryId: number): Observable<ApiResponseProduct> {

    const searchUrl = `${this.baseUrl}/search/category?id=${theCategoryId}`
      + `&page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<ApiResponseProduct>(searchUrl)
      .pipe(map(response => response))
  }

  searchProducts(theKeyword: string | null): Observable<Product[]> {
    const searchUrl = `${this.searchUrl}?name=${theKeyword}`;
    console.log(searchUrl)
    return this.getProducts(searchUrl)
  }

  searchProductsPaginate(
    thePage: number,
    thePageSize: number,
    theKeyword: string): Observable<ApiResponseProduct> {

    const searchUrl = `${this.searchUrl}?name=${theKeyword}`
      + `&page=${thePage}&size=${thePageSize}`;

    return this.httpClient.get<ApiResponseProduct>(searchUrl)
      .pipe(map(response => response))
  }

  getOneProductById(id: number): Observable<Product> {
    const url = `${this.searchUrl}/${id}`;
    return this.httpClient.get<Product>(url)
      .pipe(map(product => product))
  }


}

interface ApiResponseProduct {
  content: Product[]
  totalPages: number
  size: number
  totalElements: number,
  number: number,
  first: boolean,
  last: boolean,
  empty: boolean

}
