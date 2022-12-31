import { Component, EventEmitter, Output, OnInit } from '@angular/core';
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

  @Output() cartUpdated = new EventEmitter<{
    productId: number,
    productName: string,
    productPrice: number
  }>();

  constructor(private service: ProductService) {}

  ngOnInit() {
    this.getProduct();
  }

  getProduct() {
    this.service.getProduct().subscribe(res =>{
      this.products = res;
    });
  }

  onCartUpdated(event: { target: { getAttribute: (arg0: string) => any; }; }) {
    const id = event.target.getAttribute('id');
    const index = this.products.findIndex(elem => elem.id == id);
    this.cartUpdated.emit({
        productId: this.products[index].id,
        productName: this.products[index].name,
        productPrice: this.products[index].price
      });
}

}
