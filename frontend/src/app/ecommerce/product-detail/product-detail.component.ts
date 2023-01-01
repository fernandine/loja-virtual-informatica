import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from '../models/cart-item';
import { Product } from '../models/product';
import { CartService } from '../services/cart.service';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  product: Product;

  constructor(
    private cartService: CartService,
    private activatedRoute: ActivatedRoute,
    private productService: ProductService
  ) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe(() => {
      this.handleProductDetails()
    })
  }

  handleProductDetails() {
    const theProductId: number = +this.activatedRoute.snapshot.paramMap.get('id')!
    this.productService.getOneProductById(theProductId).subscribe(
      (data: any) => {
        this.product = data
      })
  }

  addToCart(product: Product) {
    const theCartItem =  new CartItem(this.product);
    this.cartService.addToCart(theCartItem);
  }

}
