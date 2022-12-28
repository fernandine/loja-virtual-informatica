import { Component, OnInit } from '@angular/core';
import { Product } from '../models/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  public paginaAtual = 1;

  constructor(private service: ProductService) {}

  ngOnInit() {
    this.getProduct();
  }

  getProduct() {
    this.service.getProduct().subscribe(res =>{
      this.products = res;
    });
  }
}
