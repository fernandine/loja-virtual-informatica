import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductListComponent } from '../product-list/product-list.component';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { ProductService } from '../services/product.service';
import { HomeComponent } from '../home/home.component';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from '@angular/material/input';
import { NgxPaginationModule } from 'ngx-pagination';


@NgModule({
  declarations: [
    ProductListComponent,
    HomeComponent
  ],
  imports: [
    CommonModule,
    NgxPaginationModule,
    MatCardModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatInputModule
  ],
  providers: [ProductService]
})
export class ProductModule { }
