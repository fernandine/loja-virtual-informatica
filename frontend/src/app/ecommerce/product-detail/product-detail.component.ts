import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../models/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-product-detail',
  templateUrl: './product-detail.component.html',
  styleUrls: ['./product-detail.component.scss']
})
export class ProductDetailComponent implements OnInit {

  product: any;

  constructor(private route: ActivatedRoute,
    private productService: ProductService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.product = params.get('id');
    });
    this.getProductById(this.product);
    }
  
getProductById(id:any) {
this.productService.productById(id).subscribe((res)=>{
  this.product = res;
});
}

  addToCart(product: Product) {
    this.product.push(product);
  }
}

