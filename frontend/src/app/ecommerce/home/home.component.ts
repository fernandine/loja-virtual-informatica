import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../models/product';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

   products: Product[] = [];
   public paginaAtual = 1;

  constructor(private service: ProductService,
    private route: ActivatedRoute ) {}

  ngOnInit() {
    this.getProduct();
  }

  getProduct() {
    this.service.getProduct().subscribe(api =>{
      this.products = api;
    });
  }

  }
